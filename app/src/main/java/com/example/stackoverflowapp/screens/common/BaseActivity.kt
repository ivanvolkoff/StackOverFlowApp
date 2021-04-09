package com.example.stackoverflowapp.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.*
import com.example.stackoverflowapp.common.di.activity.ActivityModule
import com.example.stackoverflowapp.common.di.activity.DaggerActivityComponent
import com.example.stackoverflowapp.common.di.presentation.DaggerPresentacionComponent
import com.example.stackoverflowapp.common.di.presentation.PresentationModule

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