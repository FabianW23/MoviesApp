package com.example.moviesapp.data.datasource.persistance

import com.example.moviesapp.presentation.authentication.database.dao.UserDao
import com.example.moviesapp.presentation.authentication.database.entities.UserEntity
import javax.inject.Inject

class PersistanceDataSourceImpl @Inject constructor(private val userDao: UserDao) : PersistanceDataSource{
    override suspend fun insertUser(userEntity: UserEntity) {
        userDao.insert(userEntity.name, userEntity.email, userEntity.password)
    }
}