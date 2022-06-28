package com.example.moviesapp.data.datasource.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.presentation.authentication.database.MovieRoomDatabase
import com.example.moviesapp.presentation.authentication.database.dao.UserDao
import com.example.moviesapp.presentation.authentication.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class  MoviesAppDataBase : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context): MovieRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieRoomDatabase::class.java,
                    "movieapp_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}