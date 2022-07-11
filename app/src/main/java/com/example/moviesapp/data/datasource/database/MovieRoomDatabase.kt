package com.example.moviesapp.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.datasource.database.dao.UserDao
import com.example.moviesapp.data.datasource.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
abstract class  MovieRoomDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

}