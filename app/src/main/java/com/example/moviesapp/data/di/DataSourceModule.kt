package com.example.moviesapp.data.di

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.datasource.cache.impl.CacheDataSourceImpl
import com.example.moviesapp.data.datasource.database.DataBaseDataSource
import com.example.moviesapp.data.datasource.database.DataBaseDataSourceImpl
import com.example.moviesapp.data.datasource.remote.RemoteDataSource
import com.example.moviesapp.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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
    abstract fun bindDataBaseDataSource(dataBaseDataSourceImpl: DataBaseDataSourceImpl): DataBaseDataSource

}