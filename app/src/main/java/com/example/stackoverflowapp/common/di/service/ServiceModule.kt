package com.example.stackoverflowapp.common.di.service

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.common.di.application.AppComponent
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ServiceModule(
    val service: Service
) {
    @Provides
    fun context() : Context = service


}