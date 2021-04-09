package com.example.stackoverflowapp.common.di

import android.app.Application
import androidx.annotation.UiThread
import com.example.stackoverflowapp.Constants
import com.example.stackoverflowapp.networking.StackOverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(private val application: Application) {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


     val stackoverflowApi: StackOverflowApi by lazy {
        retrofit.create(StackOverflowApi::class.java)  }

    @Provides
    fun application() = application
    @Provides
    fun stackOverflowApi() = stackoverflowApi

}