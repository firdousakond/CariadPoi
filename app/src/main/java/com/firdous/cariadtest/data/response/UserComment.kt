package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserComment(
    val ChargePointID: Int?,
    val CheckinStatusTypeID: Int?,
    val Comment: String?,
    val CommentTypeID: Int?,
    val DateCreated: String?,
    val ID: Int?,
    val IsActionedByEditor: Boolean?,
    val Rating: String?,
    val RelatedURL: String?,
    val UserName: String?
):Parcelable