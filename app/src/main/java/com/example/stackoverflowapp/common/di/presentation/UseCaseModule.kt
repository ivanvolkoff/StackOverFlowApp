package com.example.stackoverflowapp.common.di.presentation

import com.example.stackoverflowapp.networking.StackOverflowApi
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides
@Module
class UseCaseModule() {
    @Provides
    fun fetchQuestionsUseCase(stackOverflowApi: StackOverflowApi) =
        FetchQuestionsUseCase(stackOverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackOverflowApi: StackOverflowApi) =
        FetchQuestionDetailsUseCase(stackOverflowApi)
}