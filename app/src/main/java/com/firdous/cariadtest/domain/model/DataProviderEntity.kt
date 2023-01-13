package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataProviderEntity(
    val Comments: String?,
    val DateLastImported: String?,
    val ID: Int?,
    val IsApprovedImport: Boolean?,
    val IsOpenDataLicensed: Boolean?,
    val IsRestrictedEdit: Boolean?,
    val License: String?,
    val Title: String?,
    val WebsiteURL: String?
):Parcelable