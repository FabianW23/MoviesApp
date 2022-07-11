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

    override suspend fun selectUser(email : String, password: String): UserModel? {
        return userDao.selectUserByEmailAndPassword(email,password)?.toUserModelWithOutPassword()
    }

    override suspend fun selectUserByEmail(email: String): UserModel? {
        return userDao.selectUserByEmail(email)?.toUserModelWithOutPassword()
    }
}