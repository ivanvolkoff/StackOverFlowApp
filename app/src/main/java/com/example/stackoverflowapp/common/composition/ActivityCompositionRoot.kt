package com.example.stackoverflowapp.common.composition

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ViewMvcFactory

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val layoutInflater get() = LayoutInflater.from(activity)
    val viewMvcFactory = ViewMvcFactory(layoutInflater)
    private val fragmentManager get() = activity.supportFragmentManager

    val dialogsNavigator get() = DialogsNavigator(fragmentManager)
    private val stackoverflowApi = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}