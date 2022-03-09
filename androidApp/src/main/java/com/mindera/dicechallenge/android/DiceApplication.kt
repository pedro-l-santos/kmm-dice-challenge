package com.mindera.dicechallenge.android

import android.app.Application
import com.mindera.dicechallenge.di.initKoin

class DiceApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

}