package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OperatorInfo(
    val AddressInfo: String?,
    val BookingURL: String?,
    val Comments: String?,
    val ContactEmail: String?,
    val FaultReportEmail: String?,
    val ID: Int?,
    val IsPrivateIndividual: Boolean?,
    val IsRestrictedEdit: Boolean?,
    val PhonePrimaryContact: String?,
    val PhoneSecondaryContact: String?,
    val Title: String?,
    val WebsiteURL: String?
):Parcelable