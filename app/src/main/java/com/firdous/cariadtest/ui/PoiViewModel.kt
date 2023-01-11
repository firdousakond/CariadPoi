package com.firdous.cariadtest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firdous.cariadtest.BuildConfig
import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.data.response.PoiResponse
import com.firdous.cariadtest.domain.usecase.PoiUseCase
import com.firdous.cariadtest.util.DEFAULT_LATITUDE
import com.firdous.cariadtest.util.DEFAULT_LONGITUDE
import com.firdous.cariadtest.util.DISTANCE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class PoiViewModel(private val useCase: PoiUseCase): ViewModel() {

    private val _poiStateFlow = MutableStateFlow<Resource<PoiResponse>>(Resource.Loading)
    val poiStateFlow = _poiStateFlow.asStateFlow()

    fun getPoiList() {
        viewModelScope.launch {
            useCase.getPoiList(BuildConfig.API_KEY, DISTANCE, DEFAULT_LATITUDE, DEFAULT_LONGITUDE)
                .catch {
                    Timber.e(it.message)
                    _poiStateFlow.emit(Resource.Error(it.message ?: ""))
                }.collect {
                    _poiStateFlow.emit(it)
                }
        }
    }

}