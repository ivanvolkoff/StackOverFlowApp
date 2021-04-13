package com.example.stackoverflowapp.screens.common.viewMVC

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.common.di.activity.ActivityScope
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator (private val activity: AppCompatActivity) {

    fun navigateback() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionID: String) {
        QuestionDetailsActivity.start(activity, questionID)
    }
}