package com.example.stackoverflowapp.screens.common.viewModelsFactory

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
   private val fetchQuestionDetailsUseCaseProviders: Provider<FetchQuestionDetailsUseCase>,
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) :
    AbstractSavedStateViewModelFactory(savedStateRegistryOwner,null) {


    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
       return when (modelClass){
           MyViewModel::class.java ->{
               MyViewModel(fetchQuestionsUseCaseProvider.get(),fetchQuestionDetailsUseCaseProviders.get(),handle) as T
           }
           MyViewModel2::class.java ->{
               MyViewModel2(fetchQuestionsUseCaseProvider.get(),fetchQuestionDetailsUseCaseProviders.get(),handle)as T
           }
           else -> throw RuntimeException("Type mismatch for type: $modelClass")
       }
    }

}