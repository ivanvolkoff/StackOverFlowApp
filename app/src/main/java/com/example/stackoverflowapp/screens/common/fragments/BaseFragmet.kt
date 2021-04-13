package com.example.stackoverflowapp.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.stackoverflowapp.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
            .newPresentationComponent(

            )

    }
    protected val injector get() = presentationComponent
}