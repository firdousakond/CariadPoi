package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentTypeEntity(
    val Description: String?,
    val ID: Int?,
    val Title: String?
):Parcelable