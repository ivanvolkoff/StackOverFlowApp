package com.example.stackoverflowapp.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.stackoverflowapp.common.di.Injector
import com.example.stackoverflowapp.common.di.PresentationCompositionRoot
import com.example.stackoverflowapp.screens.common.BaseActivity

open class BaseFragmet:Fragment() {
    private val compositionRoot get() = PresentationCompositionRoot((requireActivity() as BaseActivity).activityCompositionRoot)
    protected val injector get() = Injector(compositionRoot)
}