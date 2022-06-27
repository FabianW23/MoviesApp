package com.example.moviesapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.datasource.cache.impl.CacheDataSourceImpl
import com.example.moviesapp.data.datasource.remote.RemoteDataSource
import com.example.moviesapp.data.datasource.remote.RemoteDataSourceImpl
import com.example.moviesapp.data.repository.DataBaseRepositoryImpl
import com.example.moviesapp.domain.repository.DataBaseRepository
import com.example.moviesapp.presentation.authentication.database.MovieRoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindCacheDataSource(cacheDataSourceImpl: CacheDataSourceImpl): CacheDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindPersistanceDataSource(dataBaseRepositoryImpl: DataBaseRepositoryImpl): DataBaseRepository
}