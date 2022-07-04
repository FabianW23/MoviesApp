package com.example.moviesapp.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.data.datasource.database.dao.UserDao
import com.example.moviesapp.data.datasource.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class  MovieRoomDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

}