package com.example.moviesapp.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.example.moviesapp.presentation.authentication.login.LoginFragment.Companion.LOGGED_USER_PREFERENCES
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    /*@Provides
    @Singleton
    fun providesUserLoggedPreferences(@ActivityContext context: Context): SharedPreferences? = context.getSharedPreferences(
        LOGGED_USER_PREFERENCES,Context.MODE_PRIVATE
    )*/

}