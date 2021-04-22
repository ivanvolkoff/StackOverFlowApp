package com.example.stackoverflowapp.screens.common

interface ScreensNavigator {

    fun navigateBack()
    fun toQuestionDetails(questionId: String)
    fun toViewModel()
}