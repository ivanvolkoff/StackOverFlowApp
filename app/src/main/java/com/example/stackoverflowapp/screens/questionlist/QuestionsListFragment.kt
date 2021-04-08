package com.example.stackoverflowapp.screens.questionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.questions.Question
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.fragments.BaseFragmet
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import kotlinx.coroutines.*

class QuestionsListFragment : BaseFragmet() , QuestionsListViewMvc.Listener{
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var isDataLoaded = false
    private lateinit var viewMvc: QuestionsListViewMvc
    private lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    private lateinit var dialogsNavigator: DialogsNavigator
    private lateinit var screensNavigator: ScreensNavigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        screensNavigator = compositionRoot.screensNavigator
        dialogsNavigator = compositionRoot.dialogsNavigator
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewMvc = compositionRoot.viewMvcFactory.newQuestionListViewMvcFactory(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unRegisterListener(this)
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionsUseCase.fetchLatestQuestions()) {
                    is FetchQuestionsUseCase.Result.Success -> {
                        viewMvc.bindQuestions(result.questions)
                        isDataLoaded = true
                    }
                    is FetchQuestionsUseCase.Result.Failure -> onFetchFailed()
                }
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }


    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }


    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        screensNavigator.toQuestionDetails(clickedQuestion.id)
    }


}