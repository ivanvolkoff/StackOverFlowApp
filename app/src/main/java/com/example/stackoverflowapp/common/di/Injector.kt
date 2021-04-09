package com.example.stackoverflowapp.common.di

import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsActivity
import com.example.stackoverflowapp.screens.questionlist.QuestionsListFragment

class Injector (private val compositionRoot: PresentationCompositionRoot){
    fun inject(fragment:  QuestionsListFragment) {
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }
    fun inject(activity:QuestionDetailsActivity){
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.viewMvcFactory= compositionRoot.viewMvcFactory
    }
}