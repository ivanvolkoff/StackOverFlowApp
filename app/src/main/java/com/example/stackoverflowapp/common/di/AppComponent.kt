package com.example.stackoverflowapp.common.di

import android.app.Application
import com.example.stackoverflowapp.networking.StackOverflowApi
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun application(): Application
    fun stackOverFlowApi(): StackOverflowApi
}