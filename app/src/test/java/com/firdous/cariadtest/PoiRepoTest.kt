package com.firdous.cariadtest

import com.firdous.cariadtest.data.PoiRepo
import com.firdous.cariadtest.data.RemoteDataSource
import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.domain.model.PoiResponseEntity
import com.firdous.cariadtest.domain.model.PoiResponseItemEntity
import com.firdous.cariadtest.util.DEFAULT_LATITUDE
import com.firdous.cariadtest.util.DEFAULT_LONGITUDE
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PoiRepoTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource
    private lateinit var poiRepo : PoiRepo

    @Before
    fun setup(){
        poiRepo = PoiRepo(remoteDataSource)
    }

    @Test
    fun `fetch poi list - success response`() = runTest{

       val poiResponse = PoiResponseEntity()
        val data = listOf(
            PoiResponseItemEntity(OperatorID = 100, NumberOfPoints = 5), PoiResponseItemEntity(OperatorID = 150, NumberOfPoints = 10)
        )
        poiResponse.addAll(data)

        `when`(remoteDataSource.getPoiList(BuildConfig.API_KEY,5, DEFAULT_LATITUDE, DEFAULT_LONGITUDE)).thenReturn(
            flowOf(Resource.Success(data = poiResponse)))

        val job = launch {
            poiRepo.getPoiList(BuildConfig.API_KEY, 5, DEFAULT_LATITUDE, DEFAULT_LONGITUDE)
                .collectLatest {
                   assertTrue(it is Resource.Success)
                   assertEquals(it.data[1].OperatorID, 150)
                }

        }
        job.join()
        job.cancel()
    }
}