package com.example.moviesapp.domain.di

import com.example.moviesapp.domain.usecase.validation.Impl.ValidateEmptyFieldImpl
import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ValidationObject {

    @Provides
    @Singleton
    fun bindValidateEmptyFieldUseCase(): ValidateEmptyFieldUseCase = ValidateEmptyFieldImpl()
}