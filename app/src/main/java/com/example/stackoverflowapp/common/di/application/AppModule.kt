package com.example.stackoverflowapp.common.di.application

import android.app.Application
import com.example.stackoverflowapp.Constants
import com.example.stackoverflowapp.common.di.Retrofit1
import com.example.stackoverflowapp.common.di.Retrofit2
import com.example.stackoverflowapp.networking.StackOverflowApi
import com.example.stackoverflowapp.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule @Inject constructor( val application: Application) {

    @Provides
    @AppScope
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    fun urlProvider() = UrlProvider()

    @Provides
    fun application() = application

    @Provides
    @AppScope
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit) = retrofit.create(StackOverflowApi::class.java)
}