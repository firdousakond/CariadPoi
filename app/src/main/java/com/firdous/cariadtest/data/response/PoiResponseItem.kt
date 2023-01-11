package com.firdous.cariadtest.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PoiResponseItem(
    val AddressInfo: AddressInfo? = null,
    val Connections: List<Connection>?= null,
    val DataProvider: DataProvider?= null,
    val DataProviderID: Int?= null,
    val DataQualityLevel: Int?= null,
    val DateCreated: String?= null,
    val DateLastStatusUpdate: String?= null,
    val DateLastVerified: String?= null,
    val GeneralComments: String?= null,
    val ID: Int?= null,
    val IsRecentlyVerified: Boolean?= null,
    val NumberOfPoints: Int?= null,
    val OperatorID: Int?= null,
    val OperatorInfo: OperatorInfo?= null,
    val OperatorsReference: String?= null,
    val ParentChargePointID: String?= null,
    val PercentageSimilarity: String?= null,
    val StatusTypeID: Int?= null,
    val SubmissionStatusTypeID: Int?= null,
    val UUID: String?= null,
    val UsageCost: String?= null,
    val UsageTypeID: Int?= null,
    val UserComments: List<UserComment>?= null
):Parcelable
{
    fun getNumberOfChargingPoint(): String {
        return if (NumberOfPoints != null){
            "$NumberOfPoints"
        }else{
            "0"
        }
    }
}