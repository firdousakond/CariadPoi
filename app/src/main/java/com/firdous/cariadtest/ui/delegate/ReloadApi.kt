package com.firdous.cariadtest.ui.delegate

interface ReloadApi {
    fun fetchPoiDataEveryXSeconds(delay: Long, apiCall: () -> Unit)
}