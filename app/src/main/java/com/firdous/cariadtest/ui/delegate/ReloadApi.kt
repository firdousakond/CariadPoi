package com.firdous.cariadtest.ui.delegate

interface ReloadApi {
    fun callApiEveryXDuration(delay: Long, apiCall: () -> Unit)
}