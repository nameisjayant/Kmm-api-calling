package com.nameisjayant.kmmproject.android

import android.app.Application
import com.nameisjayant.kmmproject.android.di.appModule
import com.nameisjayant.kmmproject.di.init
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init {
            androidContext(this@BaseApplication)
            modules(appModule)
        }
    }

}