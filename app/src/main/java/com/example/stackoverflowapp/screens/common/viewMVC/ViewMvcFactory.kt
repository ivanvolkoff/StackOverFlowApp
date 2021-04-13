package com.example.stackoverflowapp.screens.common.viewMVC

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stackoverflowapp.screens.common.imageloader.ImageLoader
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsViewMvc
import com.example.stackoverflowapp.screens.questionlist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) {

    fun newQuestionListViewMvcFactory(viewGroup: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, viewGroup)
    }

    fun questionDetailsViewMvc(viewGroup: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, imageLoader,viewGroup)
    }
}