package com.example.filmlistapp.domain.usecases

import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.repository.Repository

class AddFilmForFavouriteListUseCase(
    private val repository: Repository
) {

    fun addFilmForFavouriteList(filmItem: Product) {

    }
}