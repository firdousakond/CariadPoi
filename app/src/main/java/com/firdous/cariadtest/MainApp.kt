package com.firdous.cariadtest

import android.app.Application
import com.firdous.cariadtest.di.networkModule
import com.firdous.cariadtest.di.repositoryModule
import com.firdous.cariadtest.di.useCaseModule
import com.firdous.cariadtest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}