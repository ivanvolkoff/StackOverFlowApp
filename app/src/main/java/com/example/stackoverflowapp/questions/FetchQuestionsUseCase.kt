package com.example.stackoverflowapp.questions

import com.example.stackoverflowapp.Constants
import com.example.stackoverflowapp.networking.StackOverflowApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.cancellation.CancellationException

class FetchQuestionsUseCase(
    retrofit: Retrofit
) {
    sealed class Result {
        class Success(val questions: List<Question>) : Result()
        object Failure : Result()
    }

    private var stackoverflowApi: StackOverflowApi = retrofit.create(StackOverflowApi::class.java)

    suspend fun fetchLatestQuestions(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!.questions)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }

}