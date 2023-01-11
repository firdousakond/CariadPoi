package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConnectionType(
    val FormalName: String?,
    val ID: Int?,
    val IsDiscontinued: Boolean?,
    val IsObsolete: Boolean?,
    val Title: String?
):Parcelable