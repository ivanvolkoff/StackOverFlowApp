package com.example.stackoverflowapp.common.di

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.stackoverflowapp.networking.StackOverflowApi
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun activity():AppCompatActivity

    fun layoutInflater() : LayoutInflater

    fun fragmentManager(): FragmentManager

    fun stackOverflowApi(): StackOverflowApi

    fun screensNavigator():ScreensNavigator
}