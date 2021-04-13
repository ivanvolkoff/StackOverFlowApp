package com.example.stackoverflowapp.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.stackoverflowapp.common.di.application.AppComponent
import com.example.stackoverflowapp.common.di.presentation.PresentationComponent
import com.example.stackoverflowapp.common.di.presentation.PresentationModule
import com.example.stackoverflowapp.common.di.presentation.UseCaseModule
import com.example.stackoverflowapp.networking.StackOverflowApi
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(
        presentationModule: PresentationModule,
        useCaseModule: UseCaseModule
    ): PresentationComponent
}