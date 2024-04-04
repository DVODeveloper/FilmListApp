package com.example.filmlistapp.domain.entity.testEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "favourite_movies")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int = UNDEFINED_ID,

    @ColumnInfo("name")
    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    val description: String,

    @ColumnInfo("price")
    @SerializedName("price")
    val price: Int,
    @SerializedName("discountPercentage")
    val discountPercentage: Float,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
//    @SerializedName("images")
//    val images: List<String>,

    @SerializedName("clickEnable")
    var clickEnable: Boolean


): Serializable {
    companion object {
        const val UNDEFINED_ID = -1
    }
}


