package com.example.moviesapp.presentation.authentication.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.presentation.authentication.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAlphabetizedWords(): Flow<List<UserEntity>>

    @Query("INSERT INTO user_table (name,email,password) VALUES(:name,:email,:password)")
    suspend fun insert(name:String, email:String, password:String)

    @Query("SELECT id,name,email,password FROM user_table WHERE email = :email and password = :password")
    suspend fun ifUserExist(email : String, password: String) : UserEntity

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}