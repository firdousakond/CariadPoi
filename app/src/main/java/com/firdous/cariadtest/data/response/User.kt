package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val APIKey: String?,
    val CurrentSessionToken: String?,
    val DateCreated: String?,
    val DateLastLogin: String?,
    val EmailAddress: String?,
    val EmailHash: String?,
    val ID: Int?,
    val Identifier: String?,
    val IdentityProvider: String?,
    val IsCurrentSessionTokenValid: String?,
    val IsEmergencyChargingProvider: String?,
    val IsProfilePublic: String?,
    val IsPublicChargingProvider: String?,
    val Latitude: String?,
    val Location: String?,
    val Longitude: String?,
    val Permissions: String?,
    val PermissionsRequested: String?,
    val Profile: String?,
    val ProfileImageURL: String?,
    val ReputationPoints: Int?,
    val SyncedSettings: String?,
    val Username: String?,
    val WebsiteURL: String?
):Parcelable