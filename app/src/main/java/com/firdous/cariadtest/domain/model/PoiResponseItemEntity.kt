package com.firdous.cariadtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PoiResponseItemEntity(
    val AddressInfo: AddressInfoEntity? = null,
    val Connections: List<ConnectionEntity>?= null,
    val DataProvider: DataProviderEntity?= null,
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
    val OperatorInfo: OperatorInfoEntity?= null,
    val OperatorsReference: String?= null,
    val ParentChargePointID: String?= null,
    val PercentageSimilarity: String?= null,
    val StatusTypeID: Int?= null,
    val SubmissionStatusTypeID: Int?= null,
    val UUID: String?= null,
    val UsageCost: String?= null,
    val UsageTypeID: Int?= null,
    val UserComments: List<UserCommentEntity>?= null
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