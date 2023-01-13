package com.firdous.cariadtest

import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.domain.model.PoiResponseEntity
import com.firdous.cariadtest.domain.model.PoiResponseItemEntity
import com.firdous.cariadtest.domain.usecase.PoiUseCase
import com.firdous.cariadtest.ui.PoiViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
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
class PoiViewModelTest {


    @OptIn(DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Mock
    lateinit var useCase: PoiUseCase
    private lateinit var viewModel: PoiViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = PoiViewModel(useCase)
    }

    @Test
    fun `fetch poi list - success response`() = runTest(UnconfinedTestDispatcher()) {

        val poiResponse = PoiResponseEntity()
        val data = listOf(
            PoiResponseItemEntity(OperatorID = 100, NumberOfPoints = 5),
            PoiResponseItemEntity(OperatorID = 150, NumberOfPoints = 10)
        )
        poiResponse.addAll(data)

        `when`(
            useCase.getPoiList(
                anyString(),
                anyInt(),
                anyDouble(),
                anyDouble()
            )
        ).thenReturn(
            flowOf(Resource.Success(data = poiResponse))
        )
        viewModel.getPoiList()
        delay(3000)
        val job = launch {
            viewModel.poiStateFlow.collect {
                assertTrue(it is Resource.Success)
                assertEquals(it.data[1].OperatorID, 150)
            }

        }
        job.cancel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

}
