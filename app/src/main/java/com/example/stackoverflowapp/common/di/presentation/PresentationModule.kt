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
class PresentationModule() {

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)



}