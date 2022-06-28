package com.example.moviesapp.domain.repository

import com.example.moviesapp.domain.model.UserModel

interface DataBaseRepository {
    suspend fun insertUser(userModel: UserModel)
}