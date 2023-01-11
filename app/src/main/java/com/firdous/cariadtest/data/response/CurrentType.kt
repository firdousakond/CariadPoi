package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentType(
    val Description: String?,
    val ID: Int?,
    val Title: String?
):Parcelable