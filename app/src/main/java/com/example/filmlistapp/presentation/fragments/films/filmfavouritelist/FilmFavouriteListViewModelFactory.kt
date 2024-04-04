package com.example.filmlistapp.presentation.fragments.films.filmfavouritelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import java.lang.IllegalArgumentException

class FilmFavouriteListViewModelFactory(
    private val repositoryImpl: RepositoryImpl
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmFavouriteListViewModel::class.java)) {
            return FilmFavouriteListViewModel(repositoryImpl) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}