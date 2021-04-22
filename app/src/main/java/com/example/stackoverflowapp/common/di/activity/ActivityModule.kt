package com.example.stackoverflowapp.common.di.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.screens.common.ScreensNavigator
import com.example.stackoverflowapp.screens.common.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {


    @ActivityScoped
    @Binds
    abstract fun screensNavigator(screensNavigator: ScreensNavigatorImpl): ScreensNavigator

    companion object {
        @Provides
        fun layoutInflater(activity: Activity) = LayoutInflater.from(activity)

        @Provides
        fun appCompatActivity(activity: Activity) = activity as AppCompatActivity

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }


}