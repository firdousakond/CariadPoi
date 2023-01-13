package com.firdous.cariadtest.data

import com.firdous.cariadtest.domain.model.PoiResponseEntity
import com.firdous.cariadtest.domain.repository.IPoiRepo
import kotlinx.coroutines.flow.Flow

class PoiRepo(
    private val remoteDataSource: RemoteDataSource
) : IPoiRepo {
    override suspend fun getPoiList(
        key: String,
        distance: Int,
        latitude: Double,
        longitude: Double
    ): Flow<Resource<PoiResponseEntity>>  = remoteDataSource.getPoiList(key,distance,latitude,longitude)

}