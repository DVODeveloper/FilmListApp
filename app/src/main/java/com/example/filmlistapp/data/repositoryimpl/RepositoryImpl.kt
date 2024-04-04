package com.example.filmlistapp.data.repositoryimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.filmlistapp.data.network.ApiFactoryTest
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.entity.testEntity.Products
import com.example.filmlistapp.domain.repository.Repository
import java.lang.RuntimeException

object RepositoryImpl : Repository {


    var filmList = mutableListOf<Product>()
    private var autoIncrementId = 0


    override suspend fun getFilmList(): List<Product> {
        val response = ApiFactoryTest.apiServiceTest.getAllProducts()
        filmList = response.products.toMutableList()
        return filmList
    }

    private suspend fun updateList() {
        filmList = filmList.toMutableList()
    }


    override suspend fun addFilmForFavouriteList(filmItem: Product) {
        if (filmItem.id == Product.UNDEFINED_ID) {
            filmItem.id = autoIncrementId++
        }

        filmList.add(filmItem)
        updateList()
    }


    override suspend fun deleteFilmFromFavouriteList(product: Product) {
        filmList.remove(product)
        updateList()
    }


    override fun getFilmItem(filmItemId: Int): Product {
        return filmList.find { it.id == filmItemId }
            ?: throw RuntimeException("Element with id $filmItemId not found")
    }

    override suspend fun editFilmItem(product: Product) {
        val oldElement = getFilmItem(product.id)
        filmList.remove(oldElement)
        addFilmForFavouriteList(product)
    }

    override fun sortedFilmListAlphabet() {
        TODO("Not yet implemented")
    }

    override fun sortedFilmListMark() {
        TODO("Not yet implemented")
    }

    override fun sortedFilmListRank() {
        TODO("Not yet implemented")
    }

    override fun sortedFilmListRating() {
        TODO("Not yet implemented")
    }
}