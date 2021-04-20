package com.example.stackoverflowapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.activity.ActivityModule

open class BaseActivity : AppCompatActivity() {
    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponent()
            .activity(this)
            .build()
    }
    private val presentationComponent by lazy {
        activityComponent
            .newPresentationComponent(

            )

    }


    protected val injector get() = presentationComponent

}