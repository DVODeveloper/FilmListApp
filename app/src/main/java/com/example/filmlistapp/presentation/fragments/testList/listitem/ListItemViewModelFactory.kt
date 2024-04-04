package com.example.filmlistapp.presentation.fragments.testList.listitem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import java.lang.IllegalArgumentException

class ListItemViewModelFactory(
    private val repositoryImpl: RepositoryImpl
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListItemViewModel::class.java)) {
            return ListItemViewModel(repositoryImpl) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}