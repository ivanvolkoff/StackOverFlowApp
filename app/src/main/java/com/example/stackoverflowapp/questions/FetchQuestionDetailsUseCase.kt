package com.example.stackoverflowapp.questions

import com.example.stackoverflowapp.networking.StackOverflowApi
import com.techyourchance.dagger2course.questions.QuestionWithBody
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchQuestionDetailsUseCase @Inject constructor(
    private val stackoverflowApi: StackOverflowApi
) {
    sealed class Result {
        data class Success(val questionBody: QuestionWithBody) : Result()
        object Failure : Result()
    }

    suspend fun fetchQuestionDetails(questionId: String): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response != null) {
                    return@withContext Result.Success(response.body()!!.question)
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