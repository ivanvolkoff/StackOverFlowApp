package com.example.stackoverflowapp.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.screens.common.ScreensNavigator
import com.example.stackoverflowapp.screens.common.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {


    @ActivityScope
    @Binds
   abstract fun screensNavigator(screensNavigator: ScreensNavigatorImpl):ScreensNavigator

   companion object {
    @Provides
    fun layoutInflater(activity: AppCompatActivity) = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
}



}