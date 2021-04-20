package com.example.stackoverflowapp.screens.questionlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.questions.Question
import com.example.stackoverflowapp.screens.common.dialogs.DialogsNavigator
import com.example.stackoverflowapp.screens.common.fragments.BaseFragment
import com.example.stackoverflowapp.screens.common.ScreensNavigator
import com.example.stackoverflowapp.screens.common.viewmvc.ViewMvcFactory
import kotlinx.coroutines.*
import javax.inject.Inject

class QuestionsListFragment : BaseFragment(), QuestionsListViewMvc.Listener {
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private var isDataLoaded = false

    private lateinit var viewMvc: QuestionsListViewMvc
    @Inject
    lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    @Inject
    lateinit var dialogsNavigator: DialogsNavigator
    @Inject
    lateinit var screensNavigator: ScreensNavigator
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        Log.e("QuestionsListFragment","$screensNavigator")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMvc = viewMvcFactory.newQuestionsListViewMvc(container)
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
        viewMvc.unregisterListener(this)
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

    override fun onViewModelClicked() {
        screensNavigator.toViewModel()
    }


}