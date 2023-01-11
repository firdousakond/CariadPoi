package com.firdous.cariadtest.data

import com.firdous.cariadtest.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class RemoteDataSource (private val apiService: ApiService){

     suspend fun getPoiList(key: String, distance: Int, latitude: Double, longitude: Double) = flow {
             try {
                 val poiList = apiService.getPoiList(key,distance,latitude,longitude)
                 emit(Resource.Success(poiList))
             } catch (e: Exception) {
                 Timber.e(e)
                 emit(Resource.Error(e.toString()))
             }
        }.flowOn(Dispatchers.IO)

}