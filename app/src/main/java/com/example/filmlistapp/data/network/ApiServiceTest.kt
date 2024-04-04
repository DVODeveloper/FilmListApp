package com.example.filmlistapp.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.domain.entity.testEntity.Products
import retrofit2.http.GET

interface ApiServiceTest {

    @GET("products")
    suspend fun getAllProducts(): Products
}