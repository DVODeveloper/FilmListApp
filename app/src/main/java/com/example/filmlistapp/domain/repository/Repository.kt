package com.example.filmlistapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.entity.testEntity.Products

interface Repository {

    suspend fun getFilmList(): List<Product>

    suspend fun addFilmForFavouriteList(filmItem: Product)

    suspend fun deleteFilmFromFavouriteList(product: Product)

    fun getFilmItem(filmItemId: Int): Product

    suspend fun editFilmItem(product: Product)

    fun sortedFilmListAlphabet()

    fun sortedFilmListMark()

    fun sortedFilmListRank()

    fun sortedFilmListRating()


}