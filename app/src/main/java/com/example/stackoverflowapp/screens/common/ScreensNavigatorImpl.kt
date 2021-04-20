package com.example.stackoverflowapp.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsActivity
import com.example.stackoverflowapp.screens.viewModel.ViewModelActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor(private val activity: AppCompatActivity): ScreensNavigator {

    override fun navigateBack() {
        activity.onBackPressed()
    }

    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    override fun toViewModel() {
        ViewModelActivity.start(activity)
    }
}