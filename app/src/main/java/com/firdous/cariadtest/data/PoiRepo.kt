package com.firdous.cariadtest.data

import com.firdous.cariadtest.data.response.PoiResponse
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
    ): Flow<Resource<PoiResponse>>  = remoteDataSource.getPoiList(key,distance,latitude,longitude)

}