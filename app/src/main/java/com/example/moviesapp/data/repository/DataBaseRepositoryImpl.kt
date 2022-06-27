package com.example.moviesapp.data.repository

import androidx.annotation.WorkerThread
import com.example.moviesapp.presentation.authentication.database.dao.UserDao
import com.example.moviesapp.data.mapper.toUserEntity
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.DataBaseRepository
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(private val userDao: UserDao) : DataBaseRepository {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    //val allWords: Flow<List<UserEntity>> = UserDao.insert()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insertUser(user: UserModel) {
        userDao.insert(user.name,user.email,user.password)
    }
}