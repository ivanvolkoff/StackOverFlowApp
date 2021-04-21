package com.example.stackoverflowapp.screens.viewModel

import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.example.stackoverflowapp.questions.FetchQuestionDetailsUseCase
import com.example.stackoverflowapp.questions.FetchQuestionsUseCase
import com.example.stackoverflowapp.questions.Question
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


class MyViewModel2 @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase,
    private val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase,
    private val savedStateRegistryOwner: SavedStateHandle

): ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success) {
                _questions.value = result.questions
            } else {
                throw RuntimeException("fetch failed")
            }
        }
    }

    class Factory @Inject constructor(private val myViewModelProvider:Provider<MyViewModel2>):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return myViewModelProvider.get() as T
        }

    }
}