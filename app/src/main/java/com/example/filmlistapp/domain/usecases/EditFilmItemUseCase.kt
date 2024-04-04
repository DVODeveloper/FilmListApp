package com.example.filmlistapp.domain.usecases

import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.repository.Repository

class EditFilmItemUseCase(
    private val repository: Repository
) {
    suspend fun editFilmItem(product: Product) {
        return repository.editFilmItem(product)
    }
}