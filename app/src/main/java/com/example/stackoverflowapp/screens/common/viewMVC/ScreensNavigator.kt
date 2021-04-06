package com.example.stackoverflowapp.screens.common.viewMVC

import android.app.Activity
import android.content.Context
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator (private val activity: Activity){

    fun navigateback(){
        activity.onBackPressed()
    }
    fun toQuestionDetails(questionID:String){
        QuestionDetailsActivity.start(activity, questionID)
    }
}