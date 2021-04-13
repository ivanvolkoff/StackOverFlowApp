package com.example.stackoverflowapp.common.di.activity

import com.example.stackoverflowapp.common.di.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(
    ): PresentationComponent
}