package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConnectionTypeEntity(
    val FormalName: String?,
    val ID: Int?,
    val IsDiscontinued: Boolean?,
    val IsObsolete: Boolean?,
    val Title: String?
):Parcelable