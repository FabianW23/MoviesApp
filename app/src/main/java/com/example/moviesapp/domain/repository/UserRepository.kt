package com.example.moviesapp.domain.repository

import com.example.moviesapp.domain.model.UserModel

interface UserRepository {
    suspend fun insertUser(userModel: UserModel)

    suspend fun selectUser(email : String, password: String):UserModel?

    suspend fun selectUserByEmail(email : String):UserModel?
}