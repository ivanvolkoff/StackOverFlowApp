package com.example.stackoverflowapp.common.di.application

import android.app.Application
import com.example.stackoverflowapp.networking.StackOverflowApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun application(): Application
    fun stackOverFlowApi(): StackOverflowApi
}