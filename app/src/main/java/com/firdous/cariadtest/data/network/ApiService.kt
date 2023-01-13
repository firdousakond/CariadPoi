package com.firdous.cariadtest.data.network

import com.firdous.cariadtest.domain.model.PoiResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("poi")
    suspend fun getPoiList(
        @Query("key") key: String,
        @Query("distance") distance: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
        ): PoiResponseEntity
}