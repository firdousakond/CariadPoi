package com.firdous.cariadtest.domain.usecase

import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.domain.model.PoiResponseEntity
import com.firdous.cariadtest.domain.repository.IPoiRepo
import kotlinx.coroutines.flow.Flow

class PoiUseCase (private val poiRepo: IPoiRepo) {
     suspend fun getPoiList(
        key: String,
        distance: Int,
        latitude: Double,
        longitude: Double
    ): Flow<Resource<PoiResponseEntity>> = poiRepo.getPoiList(key,distance,latitude,longitude)

}