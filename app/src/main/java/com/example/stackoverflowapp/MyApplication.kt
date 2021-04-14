package com.example.stackoverflowapp

import android.app.Application
import com.example.stackoverflowapp.common.di.application.AppComponent
import com.example.stackoverflowapp.common.di.application.AppModule
import com.example.stackoverflowapp.common.di.application.DaggerAppComponent

class MyApplication : Application() {

    public val appComponent:AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {

        super.onCreate()
    }


}