package com.example.moviesapp.data.di

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.datasource.cache.impl.CacheDataSourceImpl
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
}