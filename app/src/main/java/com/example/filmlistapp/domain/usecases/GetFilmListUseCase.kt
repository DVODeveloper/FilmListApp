package com.example.filmlistapp.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.entity.testEntity.Products
import com.example.filmlistapp.domain.repository.Repository

class GetFilmListUseCase (
    private val repository: Repository
) {

    suspend fun getFilmList(): List<Product> {
        return repository.getFilmList()
    }
}