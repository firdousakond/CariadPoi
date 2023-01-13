package com.firdous.cariadtest.ui.delegate

import android.os.Handler
import android.os.Looper

class ReloadApiImpl : ReloadApi {
    override fun fetchPoiDataEveryXSeconds(delay: Long, apiCall: () -> Unit) {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                apiCall()
                handler.postDelayed(this, delay)
            }
        }, delay)
    }
}