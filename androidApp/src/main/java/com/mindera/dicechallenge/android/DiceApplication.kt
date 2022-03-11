package com.mindera.dicechallenge.android

import android.app.Application
import com.mindera.dicechallenge.android.di.appModule
import com.mindera.dicechallenge.di.commonModule
import com.mindera.dicechallenge.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class DiceApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@DiceApplication)
            modules(appModule, commonModule)
        }
    }

}