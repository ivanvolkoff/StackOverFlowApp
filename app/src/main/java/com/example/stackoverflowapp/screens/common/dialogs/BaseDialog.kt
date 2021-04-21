package com.example.stackoverflowapp.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.example.stackoverflowapp.common.di.presentation.PresentationModule
import com.example.stackoverflowapp.screens.common.activities.BaseActivity

open class BaseDialog : DialogFragment() {
    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
            .newPresentationComponent(
                PresentationModule(this)
            )
    }
    protected val injector get() = presentationComponent
}