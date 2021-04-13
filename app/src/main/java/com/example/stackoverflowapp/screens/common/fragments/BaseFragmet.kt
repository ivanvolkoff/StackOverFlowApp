package com.example.stackoverflowapp.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.stackoverflowapp.common.di.presentation.PresentationModule
import com.example.stackoverflowapp.common.di.presentation.UseCaseModule
import com.example.stackoverflowapp.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
            .newPresentationComponent(
                PresentationModule(), UseCaseModule()
            )

    }
    protected val injector get() = presentationComponent
}