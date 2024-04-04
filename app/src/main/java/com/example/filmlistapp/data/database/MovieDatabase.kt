package com.example.filmlistapp.data.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmlistapp.domain.entity.testEntity.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {

    companion object {

        private var db: MovieDatabase? = null
        private const val DB_NAME = "test.db"
        private val LOCK = Any()



        fun getInstance(context: Context): MovieDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        MovieDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun getDao(): MovieDao
}