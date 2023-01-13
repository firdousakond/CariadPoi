package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LevelEntity(
    val Comments: String?,
    val ID: Int?,
    val IsFastChargeCapable: Boolean?,
    val Title: String?
):Parcelable