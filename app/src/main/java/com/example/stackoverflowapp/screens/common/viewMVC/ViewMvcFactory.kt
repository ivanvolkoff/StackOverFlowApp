package com.example.stackoverflowapp.screens.common.viewMVC

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsViewMvc
import com.example.stackoverflowapp.screens.questionlist.QuestionsListViewMvc

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun newQuestionListViewMvcFactory(viewGroup: ViewGroup?): QuestionsListViewMvc{
        return  QuestionsListViewMvc(layoutInflater,viewGroup)
    }
    fun questionDetailsViewMvc(viewGroup: ViewGroup?):QuestionDetailsViewMvc{
        return QuestionDetailsViewMvc(layoutInflater,viewGroup)
    }
}