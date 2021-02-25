package com.tilak.apps.moshi.utilities

import android.os.Build
import android.util.Log

object LogHelper {

    fun logMessage(tag: String, message: String) {
        Log.d(tag, message)
    }
}