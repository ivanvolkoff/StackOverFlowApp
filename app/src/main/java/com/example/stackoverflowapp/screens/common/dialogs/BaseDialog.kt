package com.example.stackoverflowapp.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.example.stackoverflowapp.MyApplication
import com.example.stackoverflowapp.common.di.activity.ActivityModule
import com.example.stackoverflowapp.screens.common.activities.BaseActivity

open class BaseDialog:DialogFragment() {
    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
            .newPresentationComponent(

            )
    }
    protected val injector get() = presentationComponent
}