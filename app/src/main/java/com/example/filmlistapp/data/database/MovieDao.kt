package com.example.filmlistapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.filmlistapp.domain.entity.testEntity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert
    fun insertItem(product: Product)

    @Query("DELETE FROM favourite_movies WHERE id=:movieId")
    fun deleteItem(movieId: Int)

    @Query("SELECT * FROM favourite_movies")
    fun getAllFavouriteMovies(): LiveData<List<Product>>

    @Query("SELECT * FROM favourite_movies WHERE id =:movieId ")
    fun getFavouriteMovieItem(movieId: Int): LiveData<Product>

}