package com.example.stackoverflowapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.composition.AppCompositionRoot

open class BaseActivity: AppCompatActivity() {
    val compositionRoot get() = (application as MyApplication).appCompositionRoot
}