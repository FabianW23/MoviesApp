package com.example.moviesapp.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.moviesapp.data.datasource.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user ORDER BY name ASC")

    fun getAlphabetizedWords(): Flow<List<UserEntity>>

    @Query("INSERT INTO user (name,email,password) VALUES(:name,:email,:password)")
    suspend fun insert(name:String, email:String, password:String)

    @Query("SELECT * FROM user WHERE email = :email and password = :password LIMIT 1")
    suspend fun selectUserByEmailAndPassword(email : String, password: String) : UserEntity?

    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    suspend fun selectUserByEmail(email : String) : UserEntity?
}