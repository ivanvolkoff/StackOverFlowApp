package com.example.stackoverflowapp

import android.app.Application
import androidx.fragment.app.FragmentManager
import com.example.stackoverflowapp.common.composition.AppCompositionRoot

class MyApplication : Application() {

     lateinit var appCompositionRoot: AppCompositionRoot
     lateinit var supportFragmentManager: FragmentManager

    override fun onCreate() {
        appCompositionRoot = AppCompositionRoot()
        super.onCreate()
    }


}