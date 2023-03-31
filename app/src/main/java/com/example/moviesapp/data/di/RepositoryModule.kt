package com.example.moviesapp.data.di

import com.example.moviesapp.data.repository.*
import com.example.moviesapp.domain.repository.*
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

    @Binds
    @Singleton
    abstract fun bindContactRepository(contactRepositoryImpl: ContactRepositoryImpl) : ContactRepository
}