package com.example.moviesapp.domain.di

import com.example.moviesapp.domain.usecase.GetInteractionsUseCase
import com.example.moviesapp.domain.usecase.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import com.example.moviesapp.domain.usecase.RegisterUserUseCase
import com.example.moviesapp.domain.usecase.impl.GetInteractionsUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.GetMoviesUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.GetTopRatedMoviesUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.RegisterUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetMoviesUseCase(getMoviesUseCaseImpl: GetMoviesUseCaseImpl) : GetMoviesUseCase

    @Binds
    @Singleton
    abstract fun bindGetTopRatedMoviesUseCase(getTopRatedMoviesUseCaseImpl: GetTopRatedMoviesUseCaseImpl) : GetTopRatedMoviesUseCase

    @Binds
    @Singleton
    abstract fun bindGetInteractionsUseCase(getInteractionsUseCaseImpl: GetInteractionsUseCaseImpl): GetInteractionsUseCase

    @Binds
    @Singleton
    abstract fun bindRegisterUserUseCase(registerUserUseCaseImpl: RegisterUserUseCaseImpl): RegisterUserUseCase
}