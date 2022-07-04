package com.example.moviesapp.data.datasource.database

import com.example.moviesapp.data.datasource.database.entities.UserEntity
import com.example.moviesapp.data.mapper.toUserModelWithOutPassword
import com.example.moviesapp.domain.model.UserModel

interface DataBaseDataSource {
    suspend fun insertUser(userEntity: UserEntity)

    suspend fun ifUserExist(email : String, password: String): UserModel?
}