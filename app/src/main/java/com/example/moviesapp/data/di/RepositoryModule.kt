package com.example.moviesapp.data.di

import com.example.moviesapp.data.repository.UserRepositoryImpl
import com.example.moviesapp.data.repository.InteractionRepositoryImpl
import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.data.repository.StringRepositoryImpl
import com.example.moviesapp.domain.repository.UserRepository
import com.example.moviesapp.domain.repository.InteractionRepository
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.repository.StringRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl) : MovieRepository

    @Binds
    @Singleton
    abstract fun bindInteractionRepository(interactionRepositoryImpl: InteractionRepositoryImpl) : InteractionRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl) : UserRepository

    @Binds
    @Singleton
    abstract fun bindStringRepository(stringRepositoryImpl: StringRepositoryImpl) : StringRepository
}