package com.example.moviesapp.domain.di

import com.example.moviesapp.domain.usecase.interaction.GetInteractionsUseCase
import com.example.moviesapp.domain.usecase.movie.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.example.moviesapp.domain.usecase.authentication.RegisterUserUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import com.example.moviesapp.domain.usecase.interaction.impl.GetInteractionsUseCaseImpl
import com.example.moviesapp.domain.usecase.movie.impl.GetMoviesUseCaseImpl
import com.example.moviesapp.domain.usecase.movie.impl.GetTopRatedMoviesUseCaseImpl
import com.example.moviesapp.domain.usecase.authentication.impl.RegisterUserUseCaseImpl
import com.example.moviesapp.domain.usecase.authentication.impl.SelectUserUseCaseImpl
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

    @Binds
    @Singleton
    abstract fun bindSelectUserUseCase(selectUserUseCaseImpl: SelectUserUseCaseImpl): SelectUserUseCase
}