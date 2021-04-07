package com.example.stackoverflowapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.composition.ActivityCompositionRoot

open class BaseActivity : AppCompatActivity() {
    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    val compositionRoot by lazy { ActivityCompositionRoot(this,appCompositionRoot) }

}