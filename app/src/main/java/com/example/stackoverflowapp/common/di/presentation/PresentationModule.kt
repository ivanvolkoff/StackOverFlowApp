package com.example.stackoverflowapp.common.di.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.example.stackoverflowapp.common.di.activity.ActivityComponent
import com.example.stackoverflowapp.networking.StackOverflowApi
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityComponent: ActivityComponent) {
    @Provides
    fun layoutInflater() = activityComponent.layoutInflater()

    @Provides
    fun fragmentManager() = activityComponent.fragmentManager()

    @Provides
    fun stackoverflowApi() = activityComponent.stackOverflowApi()

    @Provides
    fun activity() = activityComponent.activity()

    @Provides
    fun screensNavigator() = activityComponent.screensNavigator()

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackOverflowApi: StackOverflowApi) =
        FetchQuestionsUseCase(stackOverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackOverflowApi: StackOverflowApi) =
        FetchQuestionDetailsUseCase(stackOverflowApi)
}