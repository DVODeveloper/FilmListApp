package com.example.filmlistapp.presentation.fragments.films.filmlist

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
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

class FilmListViewModel(repositoryImpl: RepositoryImpl) : ViewModel() {

    private val repository = RepositoryImpl

    private val getFilmListUseCase = GetFilmListUseCase(repository)
    private val deleteFilmFromFavouriteListUseCase = DeleteFilmFromFavouriteListUseCase(repository)
    private val editFilmItemUseCase = EditFilmItemUseCase(repository)




    private val _testList: MutableLiveData<List<Product>> =  MutableLiveData<List<Product>>()

    val testList: LiveData<List<Product>>
        get() = _testList

    private val _enableState = MutableLiveData<Boolean>()




    fun getTestList() {
        viewModelScope.launch {
            try {
                val testList =  getFilmListUseCase.getFilmList()
                _testList.value = testList
            } catch (e: Exception) {
                Log.d("FilmListViewModel", e.toString())
            }
        }
    }

    suspend fun deleteFilmItem(product: Product) {
        viewModelScope.launch{
            try {
                deleteFilmFromFavouriteListUseCase.deleteFilmFromFavouriteList(product)
                     getTestList()
            } catch (e: Exception) {
                Log.d("FilmListViewModel", e.toString())
            }
        }

    }

    fun changeEnableState(product: Product) {
        viewModelScope.launch {
            try {
                val newItem = product.copy(clickEnable = !product.clickEnable)
                _enableState.value = newItem.clickEnable
   //             editFilmItemUseCase.editFilmItem(newItem)
            } catch (e: Exception) {
                Log.d("FilmListViewModel", e.toString())
            }

        }


    }
}