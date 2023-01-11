package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val ContinentCode: String?,
    val ID: Int?,
    val ISOCode: String?,
    val Title: String?
):Parcelable