package com.firdous.cariadtest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firdous.cariadtest.BuildConfig
import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.domain.model.PoiResponseEntity
import com.firdous.cariadtest.domain.usecase.PoiUseCase
import com.firdous.cariadtest.ui.delegate.ReloadApi
import com.firdous.cariadtest.ui.delegate.ReloadApiImpl
import com.firdous.cariadtest.util.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class PoiViewModel(private val useCase: PoiUseCase): ViewModel(), ReloadApi by ReloadApiImpl(),KoinComponent {

    private val iNetworkUtil: INetworkUtil by inject()
    private val _poiStateFlow = MutableStateFlow<Resource<PoiResponseEntity>>(Resource.Loading)
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

    fun callApiEveryXDuration(){
        fetchPoiDataEveryXSeconds(DELAY_30_SECOND) {
            getPoiList()
        }
    }

    fun isInternetConnected() = iNetworkUtil.isInternetConnected()
}