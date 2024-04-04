package com.example.filmlistapp.domain.entity.filmEntity

data class CardDetailOfFilm (

    val image: String,
    val title: String,
    val description: String,
    val rating: Int,
    val dateOfRelease: String,
    val listActors: String   // Привести в соответствие данные список актеров


)