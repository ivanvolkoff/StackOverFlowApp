package com.example.stackoverflowapp.screens.common.viewmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stackoverflowapp.screens.common.imageloader.ImageLoader
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsViewMvc
import com.example.stackoverflowapp.screens.questionlist.QuestionsListViewMvc
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject constructor(
    private val layoutInflaterProvider: Provider<LayoutInflater>,
    private val imageLoaderProvider: Provider<ImageLoader>
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflaterProvider.get(), parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflaterProvider.get(), imageLoaderProvider.get(), parent)
    }
}