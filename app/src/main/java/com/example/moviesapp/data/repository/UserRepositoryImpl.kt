package com.example.moviesapp.data.repository

import com.example.moviesapp.data.datasource.database.DataBaseDataSource
import com.example.moviesapp.data.mapper.toUserEntity
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dataBaseDataSource: DataBaseDataSource) : UserRepository {

    override suspend fun insertUser(user: UserModel) {
        dataBaseDataSource.insertUser(user.toUserEntity())
    }

    override suspend fun selectUser(email : String, password: String): UserModel? {
        return dataBaseDataSource.selectUser(email,password)
    }

    override suspend fun selectUserByEmail(email: String): UserModel? {
        return dataBaseDataSource.selectUserByEmail(email)
    }
}