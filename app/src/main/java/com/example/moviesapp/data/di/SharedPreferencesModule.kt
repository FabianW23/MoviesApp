package com.example.moviesapp.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.LOGGED_USER_PREFERENCES
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) :SharedPreferences =
        app.applicationContext.getSharedPreferences(LOGGED_USER_PREFERENCES,Context.MODE_PRIVATE)
}