package com.example.stackoverflowapp.screens.common.viewModelsFactory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

abstract class SavedStateViewModel :ViewModel(){
    abstract fun init(savedStateHandle: SavedStateHandle)
}