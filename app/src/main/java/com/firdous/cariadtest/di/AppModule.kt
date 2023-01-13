package com.firdous.cariadtest.di

import com.firdous.cariadtest.domain.usecase.PoiUseCase
import com.firdous.cariadtest.ui.PoiViewModel
import com.firdous.cariadtest.ui.util.INetworkUtil
import com.firdous.cariadtest.ui.util.NetworkUtil
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule  = module {
    factory{PoiUseCase(get())}
}
val viewModelModule = module {
    viewModel { PoiViewModel(get()) }
}
val uiModule = module {
    single<INetworkUtil>{
        NetworkUtil(androidContext())
    }
}
