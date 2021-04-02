package com.example.stackoverflowapp.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.stackoverflowapp.Constants
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.networking.StackOverflowApi
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.screens.common.dialogs.ServerErrorDialogFragment
import com.example.stackoverflowapp.screens.common.toolbar.MyToolbar
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionDetailsActivity : AppCompatActivity(),QuestionDetailsViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private lateinit var questionDetailsMvc: QuestionDetailsViewMvc
    private lateinit var stackoverflowApi: StackOverflowApi
    private lateinit var questionId: String
    private  lateinit var  fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        questionDetailsMvc = QuestionDetailsViewMvc(LayoutInflater.from(this),null)
        setContentView(questionDetailsMvc.rootView)
        fetchQuestionDetailsUseCase = FetchQuestionDetailsUseCase()




        // retrieve question ID passed from outside
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
              when(val result = fetchQuestionDetailsUseCase.fetchQuestionDetails(questionId)){
                  is FetchQuestionDetailsUseCase.Result.Success ->{
                      questionDetailsMvc.bindQuestionBody(result.questionBody)
                  }
                  is FetchQuestionDetailsUseCase.Result.Failure ->{
                      onFetchFailed()
                  }
              }
            } finally {
                questionDetailsMvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        supportFragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
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
        onBackClicked()
    }
}