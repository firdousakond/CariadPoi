package com.firdous.cariadtest.di

import com.firdous.cariadtest.domain.usecase.PoiUseCase
import com.firdous.cariadtest.ui.PoiViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule  = module {
    factory{PoiUseCase(get())}
}
val viewModelModule = module {
    viewModel { PoiViewModel(get()) }
}
