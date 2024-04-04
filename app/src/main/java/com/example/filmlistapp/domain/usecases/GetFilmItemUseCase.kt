package com.example.filmlistapp.domain.usecases

import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.repository.Repository

class GetFilmItemUseCase(
    private val repository: Repository
) {
    fun getFilmItem(filmItemId: Int): Product {
        return repository.getFilmItem(filmItemId)
    }
}