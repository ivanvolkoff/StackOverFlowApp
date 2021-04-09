package com.example.stackoverflowapp.common.di

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val layoutInflater get() = LayoutInflater.from(activity)
    val fragmentManager get() = activity.supportFragmentManager
    val stackoverflowApi = appCompositionRoot.stackoverflowApi
}