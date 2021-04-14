package com.example.stackoverflowapp.common.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowapp.common.di.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(
    ): PresentationComponent

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance fun activity(activity:AppCompatActivity):Builder
        fun activityModule(activityModule:ActivityModule):Builder
        fun build():ActivityComponent
    }
}