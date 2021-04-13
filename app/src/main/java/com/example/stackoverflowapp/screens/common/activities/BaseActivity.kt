package com.example.stackoverflowapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.activity.ActivityModule
import com.example.stackoverflowapp.common.di.presentation.PresentationModule
import com.example.stackoverflowapp.common.di.presentation.UseCaseModule

open class BaseActivity : AppCompatActivity() {
    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }
    private val presentationComponent by lazy {
        activityComponent
            .newPresentationComponent(
                PresentationModule(),
                UseCaseModule()
            )

    }


    protected val injector get() = presentationComponent

}