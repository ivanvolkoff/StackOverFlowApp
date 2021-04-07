package com.example.stackoverflowapp.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.stackoverflowapp.screens.common.activities.BaseActivity

open class BaseFragmet:Fragment() {
    protected val compositionRoot get() = (requireActivity()as BaseActivity).compositionRoot
}