package com.example.stackoverflowapp.common.di

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    private val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    @Provides
    fun activity()= activity

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi() = appComponent.stackOverFlowApi()
}