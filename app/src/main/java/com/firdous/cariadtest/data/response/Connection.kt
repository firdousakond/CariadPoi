package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Connection(
    val Amps: Int?,
    val Comments: String?,
    val ConnectionType: ConnectionType?,
    val ConnectionTypeID: Int?,
    val CurrentType: CurrentType?,
    val CurrentTypeID: Int?,
    val ID: Int?,
    val Level: Level?,
    val LevelID: Int?,
    val PowerKW: Double?,
    val Quantity: Int?,
    val Reference: String?,
    val StatusTypeID: Int?,
    val Voltage: Int?
):Parcelable