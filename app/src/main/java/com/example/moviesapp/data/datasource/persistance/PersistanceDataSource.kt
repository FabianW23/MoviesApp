package com.example.moviesapp.data.datasource.persistance

import com.example.moviesapp.presentation.authentication.database.entities.UserEntity

interface PersistanceDataSource {
    suspend fun insertUser(userEntity: UserEntity)
}