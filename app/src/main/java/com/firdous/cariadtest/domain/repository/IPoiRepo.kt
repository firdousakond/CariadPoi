package com.firdous.cariadtest.domain.repository

import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.domain.model.PoiResponseEntity
import kotlinx.coroutines.flow.Flow

interface IPoiRepo {
    suspend fun getPoiList(key: String, distance: Int, latitude: Double, longitude: Double): Flow<Resource<PoiResponseEntity>>
}