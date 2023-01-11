package com.firdous.cariadtest

import com.firdous.cariadtest.data.RemoteDataSource
import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.data.network.ApiService
import com.firdous.cariadtest.data.response.PoiResponse
import com.firdous.cariadtest.data.response.PoiResponseItem
import com.firdous.cariadtest.util.DEFAULT_LATITUDE
import com.firdous.cariadtest.util.DEFAULT_LONGITUDE
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RemoteDataSourceTest {

    @Mock
    lateinit var apiService: ApiService
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup(){
        remoteDataSource = RemoteDataSource(apiService)
    }

    @Test
    fun `fetch poi list - success response`() = runTest{

       val poiResponse = PoiResponse()
        val data = listOf(
            PoiResponseItem(OperatorID = 100, NumberOfPoints = 5), PoiResponseItem(OperatorID = 150, NumberOfPoints = 10))
        poiResponse.addAll(data)

        `when`(apiService.getPoiList(anyString(), anyInt(), anyDouble(), anyDouble())).thenReturn(
            poiResponse)

        val job = launch {
            remoteDataSource.getPoiList(BuildConfig.API_KEY, 5, DEFAULT_LATITUDE, DEFAULT_LONGITUDE)
                .collectLatest {
                   assertTrue(it is Resource.Success)
                   assertEquals(it.data[1].NumberOfPoints, 10)
                }

        }
        job.join()
        job.cancel()
    }
}