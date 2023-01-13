package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryEntity(
    val ContinentCode: String?,
    val ID: Int?,
    val ISOCode: String?,
    val Title: String?
):Parcelable