package com.example.filmlistapp.domain.entity.testEntity

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("products")
    val products: List<Product>
)
