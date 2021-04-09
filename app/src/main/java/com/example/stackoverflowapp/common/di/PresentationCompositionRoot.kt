package com.example.stackoverflowapp.common.di

import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ViewMvcFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val layoutInflater get() = activityCompositionRoot.layoutInflater
    private val fragmentManager get() = activityCompositionRoot.fragmentManager
    val screensNavigator get() = activityCompositionRoot.screensNavigator
    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val dialogsNavigator get() = DialogsNavigator(fragmentManager)
    val stackoverflowApi = activityCompositionRoot.stackoverflowApi
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}