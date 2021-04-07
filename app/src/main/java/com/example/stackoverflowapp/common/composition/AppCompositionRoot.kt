package com.example.stackoverflowapp.common.composition

import androidx.annotation.UiThread
import com.example.stackoverflowapp.Constants
import com.example.stackoverflowapp.networking.StackOverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread
class AppCompositionRoot {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


     val stackoverflowApi: StackOverflowApi by lazy {
        retrofit.create(StackOverflowApi::class.java)  }
}