package com.example.filmlistapp.presentation.fragments.films.filmfavouritelist

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlistapp.data.database.MovieDao
import com.example.filmlistapp.data.database.MovieDatabase
import com.example.filmlistapp.data.repositoryimpl.RepositoryImpl
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.usecases.DeleteFilmFromFavouriteListUseCase
import com.example.filmlistapp.domain.usecases.EditFilmItemUseCase
import com.example.filmlistapp.domain.usecases.GetFilmListUseCase
import kotlinx.coroutines.launch

class FilmFavouriteListViewModel(repositoryImpl: RepositoryImpl) : ViewModel() {

    private val repository = RepositoryImpl

    private val getFilmListUseCase = GetFilmListUseCase(repository)
    private val deleteFilmFromFavouriteListUseCase = DeleteFilmFromFavouriteListUseCase(repository)
    private val editFilmItemUseCase = EditFilmItemUseCase(repository)

    private lateinit var movieDao: MovieDao

    private val _testFavouriteList: MutableLiveData<List<Product>> =  MutableLiveData<List<Product>>()

    val testFavouriteList: LiveData<List<Product>>
        get() = _testFavouriteList



    fun getTestFavouriteList() {

    }

//    fun getTestFavouriteList() {
//        viewModelScope.launch {
//            try {
//                val testList =  getFilmListUseCase.getFilmList()
//                _testFavouriteList.value = testList
//            } catch (e: Exception) {
//                Log.d("FilmListViewModel", e.toString())
//            }
//        }
//    }
}