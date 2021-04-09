package com.example.stackoverflowapp

import android.app.Application
import com.example.stackoverflowapp.common.di.AppModule
import com.example.stackoverflowapp.common.di.DaggerAppComponent

class MyApplication : Application() {

    public val appComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {

        super.onCreate()
    }


}