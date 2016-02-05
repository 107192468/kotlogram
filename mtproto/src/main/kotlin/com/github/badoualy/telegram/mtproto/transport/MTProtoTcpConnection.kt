package com.github.badoualy.telegram.mtproto.transport

import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.ByteBufferUtils.*
import java.io.IOException
import java.net.InetSocketAddress
import java.net.StandardSocketOptions
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.SocketChannel

class MTProtoTcpConnection
@Throws(IOException::class)
@JvmOverloads constructor(override val ip: String, override val port: Int, abridgedProtocol: Boolean = true) : MTProtoConnection {

    private val TAG = "MTProtoTcpConnection"

    private val socketChannel: SocketChannel

    init {
        socketChannel = SocketChannel.open()
        socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true)
        socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true)
        socketChannel.configureBlocking(true)
        socketChannel.connect(InetSocketAddress(ip, port))

        if (abridgedProtocol) {
            // @see https://core.telegram.org/mtproto/samples-auth_key
            socketChannel.write(ByteBuffer.wrap(byteArrayOf(0xef.toByte())))
        }

        Log.d(TAG, "Connected to $ip:$port")
    }

    @Throws(IOException::class)
    override fun readMessage(): ByteArray {
        /*
        (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4)
         */

        // Read message length
        var length = readByteAsInt(readBytes(1))
        if (length == 0x7f)
            length = readInt24(readBytes(3, ByteOrder.BIG_ENDIAN))

        val buffer = readBytes(length * 4)

        // TODO: fix to return bytebuffer
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes, 0, buffer.remaining())
        return bytes
    }

    @Throws(IOException::class)
    override fun writeMessage(request: ByteArray) {
        val length = request.size / 4
        val headerLength = if (length >= 127) 4 else 1
        val buffer = ByteBuffer.allocateDirect(request.size + headerLength)

        /*
        There is an abridged version of the same protocol: if the client sends 0xef as the first byte
        (**important:** only prior to the very first data packet),
        then packet length is encoded by a single byte (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4) followed by the data themselves (sequence number and CRC32 not added).
        In this case, server responses look the same (the server does not send 0xef as the first byte).
         */
        if (headerLength == 4) {
            writeByte(127, buffer)
            writeInt24(length, buffer)
        } else {
            writeByte(length, buffer)
        }

        buffer.put(request)
        buffer.flip()
        writeBytes(buffer)
    }

    @Throws(IOException::class)
    override fun executeMethod(request: ByteArray): ByteArray {
        writeMessage(request)
        return readMessage()
    }

    @Throws(IOException::class)
    override fun close() {
        Log.d(TAG, "Closing connection")
        socketChannel.close()
    }

    override fun isOpened() = socketChannel.isOpen && socketChannel.isConnected

    private fun readBytes(length: Int, order: ByteOrder = ByteOrder.BIG_ENDIAN): ByteBuffer {
        val buffer = ByteBuffer.allocateDirect(length)
        buffer.order(order)
        var totalRead = 0

        while (totalRead < length) {
            var read = socketChannel.read(buffer)
            if (read == -1)
                throw IOException("Reached end-of-stream")

            totalRead += read
        }

        buffer.flip()
        return buffer
    }

    private fun writeBytes(buffer: ByteBuffer) {
        while (buffer.hasRemaining())
            socketChannel.write(buffer)
    }
}
