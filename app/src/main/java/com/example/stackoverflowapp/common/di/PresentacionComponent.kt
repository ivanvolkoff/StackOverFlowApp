package com.example.stackoverflowapp.common.di

import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentacionComponent {
    fun viewMvcFactory(): ViewMvcFactory
    fun screensNavigator(): ScreensNavigator
    fun dialogsNavigator(): DialogsNavigator
    fun fetchQuestionsUseCase(): FetchQuestionsUseCase
    fun fetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
}