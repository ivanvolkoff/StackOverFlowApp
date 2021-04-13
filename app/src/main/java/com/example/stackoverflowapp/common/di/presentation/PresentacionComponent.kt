package com.example.stackoverflowapp.common.di.presentation

import com.example.stackoverflowapp.common.di.activity.ActivityComponent
import com.example.stackoverflowapp.screens.questiondetails.QuestionDetailsActivity
import com.example.stackoverflowapp.screens.questionlist.QuestionsListFragment
import dagger.Component
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class,UseCaseModule::class])
interface PresentationComponent {
    fun inject(fragment:QuestionsListFragment)
    fun inject(activity: QuestionDetailsActivity)
}