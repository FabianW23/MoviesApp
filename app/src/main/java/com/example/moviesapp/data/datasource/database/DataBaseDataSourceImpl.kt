package com.example.moviesapp.data.datasource.database

import com.example.moviesapp.data.datasource.database.dao.UserDao
import com.example.moviesapp.data.datasource.database.entities.UserEntity
import com.example.moviesapp.data.mapper.toUserModelWithOutPassword
import com.example.moviesapp.domain.model.UserModel
import javax.inject.Inject

class DataBaseDataSourceImpl @Inject constructor(private val userDao: UserDao) :
    DataBaseDataSource {
    override suspend fun insertUser(userEntity: UserEntity) {
        userDao.insert(userEntity.name, userEntity.email, userEntity.password)
    }

    override suspend fun ifUserExist(email : String, password: String): UserModel? {
        return userDao.ifUserExist(email,password)?.toUserModelWithOutPassword()
    }
}