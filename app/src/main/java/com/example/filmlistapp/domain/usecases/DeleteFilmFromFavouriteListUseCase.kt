package com.example.filmlistapp.domain.usecases

import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.repository.Repository

class DeleteFilmFromFavouriteListUseCase(
    private val repository: Repository
) {

    suspend fun deleteFilmFromFavouriteList(product: Product) {

    }
}