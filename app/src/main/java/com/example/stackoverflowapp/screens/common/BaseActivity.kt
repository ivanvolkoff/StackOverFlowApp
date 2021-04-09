package com.example.stackoverflowapp.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.*

open class BaseActivity : AppCompatActivity() {
    private val appCompositionRoot get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this, appCompositionRoot))
            .build()
    }
    private val presentationComponent by lazy {
        DaggerPresentacionComponent.builder()
            .presentationModule(PresentationModule(activityComponent)).build()
    }


    protected val injector get() = Injector(presentationComponent)

}