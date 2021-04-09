package com.example.stackoverflowapp.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.screens.common.BaseActivity
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import com.example.stackoverflowapp.screens.common.viewMVC.ViewMvcFactory
import kotlinx.coroutines.*

class QuestionDetailsActivity : BaseActivity(), QuestionDetailsViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

     lateinit var questionDetailsMvc: QuestionDetailsViewMvc

     lateinit var questionId: String

     lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
     lateinit var viewMvcFactory: ViewMvcFactory
     lateinit var dialogsNavigator: DialogsNavigator
     lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(questionDetailsMvc.rootView)
        questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!
    }

    override fun onStart() {
        super.onStart()
        questionDetailsMvc.registerListener(this)
        fetchQuestionDetails()
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        questionDetailsMvc.unregisterListener(this)

    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            questionDetailsMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionDetailsUseCase.fetchQuestionDetails(questionId)) {
                    is FetchQuestionDetailsUseCase.Result.Success -> {
                        questionDetailsMvc.bindQuestionBody(result.questionBody)
                    }
                    is FetchQuestionDetailsUseCase.Result.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                questionDetailsMvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }


    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }

    override fun onBackClicked() {
        screensNavigator.navigateback()
    }
}