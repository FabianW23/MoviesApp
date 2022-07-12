package com.example.moviesapp.domain.di

import com.example.moviesapp.domain.helpers.validation.StringValidationHelper
import com.example.moviesapp.domain.helpers.validation.impl.StringValidationHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HelpersModule {

    @Singleton
    @Provides
    fun bindStringValidationHelper() : StringValidationHelper = StringValidationHelperImpl()
}