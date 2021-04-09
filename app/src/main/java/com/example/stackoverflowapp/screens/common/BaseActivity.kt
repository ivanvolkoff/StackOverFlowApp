package com.example.stackoverflowapp.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.ActivityCompositionRoot
import com.example.stackoverflowapp.common.di.Injector
import com.example.stackoverflowapp.common.di.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {
    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }
    private val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

    protected val injector get() = Injector(compositionRoot)

}