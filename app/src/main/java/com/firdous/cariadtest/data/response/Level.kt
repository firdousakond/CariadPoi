package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Level(
    val Comments: String?,
    val ID: Int?,
    val IsFastChargeCapable: Boolean?,
    val Title: String?
):Parcelable