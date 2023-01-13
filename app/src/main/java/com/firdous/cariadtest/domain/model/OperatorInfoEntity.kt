package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OperatorInfoEntity(
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