package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.lang.StringBuilder

@Parcelize
data class AddressInfoEntity(
    val AccessComments: String?,
    val AddressLine1: String?,
    val AddressLine2: String?,
    val ContactEmail: String?,
    val ContactTelephone1: String?,
    val ContactTelephone2: String?,
    val Country: CountryEntity?,
    val CountryID: Int?,
    val Distance: String?,
    val DistanceUnit: Int?,
    val ID: Int?,
    val Latitude: Double?,
    val Longitude: Double?,
    val Postcode: String?,
    val RelatedURL: String?,
    val StateOrProvince: String?,
    val Title: String?,
    val Town: String?
) : Parcelable {
    fun getFullAddress(): String {
        val sb = StringBuilder()
        if (!AddressLine1.isNullOrEmpty()) {
            sb.append(AddressLine1).append(", ")
        }
        if (!AddressLine2.isNullOrEmpty()) {
            sb.append(AddressLine2).append("\n")
        }
        if (!Town.isNullOrEmpty()) {
            sb.append(Town).append(", ")
        }
        if (Country != null && !Country.Title.isNullOrEmpty()) {
            sb.append(Country.Title)
        }
        return sb.toString()
    }
}