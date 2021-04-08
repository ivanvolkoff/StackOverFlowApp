package com.example.stackoverflowapp.screens.common.viewMVC

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsViewMvc
import com.example.stackoverflowapp.screens.questionlist.QuestionsListViewMvc

class ViewMvcFactory(val layoutInflater: LayoutInflater) {

    fun newQuestionListViewMvcFactory(viewGroup: ViewGroup?): QuestionsListViewMvc{
        return  QuestionsListViewMvc(layoutInflater,viewGroup)
    }
    fun newQuestiopnDetailsViewMvcFactory():QuestionDetailsViewMvc{
        return QuestionDetailsViewMvc(layoutInflater,null)
    }
}