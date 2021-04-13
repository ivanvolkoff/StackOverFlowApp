package com.example.stackoverflowapp.common.service

import android.app.Service
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.service.ServiceModule

abstract class BaseService :Service(){

    private val appComponent get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }
}