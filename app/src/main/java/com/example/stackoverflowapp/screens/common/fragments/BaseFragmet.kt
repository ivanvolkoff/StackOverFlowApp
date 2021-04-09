package com.example.stackoverflowapp.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.stackoverflowapp.common.di.Injector
import com.example.stackoverflowapp.common.di.presentation.DaggerPresentacionComponent
import com.example.stackoverflowapp.common.di.presentation.PresentationModule
import com.example.stackoverflowapp.screens.common.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentacionComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityComponent))
            .build()
    }
    protected val injector get() = Injector(presentationComponent)
}