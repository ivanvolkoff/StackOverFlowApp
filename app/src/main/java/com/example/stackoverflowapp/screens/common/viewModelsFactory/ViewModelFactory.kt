package com.example.stackoverflowapp.screens.common.viewModelsFactory

import android.view.View
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.screens.viewModel.MyViewModel
import com.example.stackoverflowapp.screens.viewModel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) :
    AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {


    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {

        val provider = providersMap[modelClass]
        val viewModel = provider?.get() ?: throw RuntimeException("Unsupported viewModel type: $modelClass")
        if (viewModel is SavedStateViewModel) {
            viewModel.init(handle)
        }
        return viewModel as T
    }

}