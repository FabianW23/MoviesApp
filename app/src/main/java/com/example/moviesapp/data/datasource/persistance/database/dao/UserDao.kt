package com.example.moviesapp.data.datasource.persistance.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.moviesapp.presentation.authentication.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: UserEntity)

    /*@Query("SELECT * FROM user_table Where id =:id")
    fun getUser(id : Int): UserEntity*/
}