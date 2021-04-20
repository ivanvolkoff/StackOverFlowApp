package com.example.stackoverflowapp.screens.common

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.common.di.activity.ActivityScope
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

interface ScreensNavigator {

    fun navigateBack()
    fun toQuestionDetails(questionId: String)
    fun toViewModel()
}