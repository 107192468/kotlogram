package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.util.Log

object Kotlogram {

    internal val API_LAYER = 45

    @JvmOverloads @JvmStatic
    fun getDefaultClient(application: TelegramApp, apiStorage: TelegramApiStorage, preferredDataCenter: DataCenter = PROD_DC4)
            : TelegramClient = DefaultTelegramClient(application, apiStorage, preferredDataCenter)

    //    @JvmOverloads @JvmStatic
    //    fun getDefaultReactiveClient(application: TelegramApp, apiStorage: TelegramApiStorage, preferredDataCenter: DataCenter = PROD_DC4)
    //            : TelegramReactiveClient = DefaultTelegramReactiveClient(application, apiStorage, preferredDataCenter)

    @JvmStatic
    fun setDebugLogEnabled(enabled: Boolean) {
        Log.enabled = enabled
    }

    @JvmStatic @JvmField val PROD_DC1 = DataCenter("149.154.175.50", 443)
    @JvmStatic @JvmField val PROD_DC2 = DataCenter("149.154.167.51", 443)
    @JvmStatic @JvmField val PROD_DC3 = DataCenter("149.154.175.100", 443)
    @JvmStatic @JvmField val PROD_DC4 = DataCenter("149.154.167.91", 443)
    @JvmStatic @JvmField val PROD_DC5 = DataCenter("91.108.56.165", 443)

    @JvmStatic @JvmField val PROD_DCS = arrayOf(PROD_DC1, PROD_DC2, PROD_DC3, PROD_DC4, PROD_DC5)
}

