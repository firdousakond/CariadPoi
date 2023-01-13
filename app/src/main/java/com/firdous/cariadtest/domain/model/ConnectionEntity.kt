package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConnectionEntity(
    val Amps: Int?,
    val Comments: String?,
    val ConnectionType: ConnectionTypeEntity?,
    val ConnectionTypeID: Int?,
    val CurrentType: CurrentTypeEntity?,
    val CurrentTypeID: Int?,
    val ID: Int?,
    val Level: LevelEntity?,
    val LevelID: Int?,
    val PowerKW: Double?,
    val Quantity: Int?,
    val Reference: String?,
    val StatusTypeID: Int?,
    val Voltage: Int?
):Parcelable