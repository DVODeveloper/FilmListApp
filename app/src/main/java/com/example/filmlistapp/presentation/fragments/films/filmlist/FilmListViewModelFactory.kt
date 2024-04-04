package com.example.filmlistapp.presentation.fragments.films.filmlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import java.lang.IllegalArgumentException

class FilmListViewModelFactory(
    private val repositoryImpl: RepositoryImpl
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmListViewModel::class.java)) {
            return FilmListViewModel(repositoryImpl) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}