package com.example.stackoverflowapp.common.di.application

import android.app.Application
import com.example.stackoverflowapp.Constants
import com.example.stackoverflowapp.networking.StackOverflowApi
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
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @AppScope
    @Provides
    fun stackOverflowApi(retrofit: Retrofit) = retrofit.create(StackOverflowApi::class.java)

}