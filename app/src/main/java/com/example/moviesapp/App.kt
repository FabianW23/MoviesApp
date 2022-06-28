package com.example.moviesapp

import android.app.Application
import android.content.Context
import com.example.moviesapp.presentation.authentication.database.DataBaseRepositoryImpl
import com.example.moviesapp.presentation.authentication.database.MovieRoomDatabase

import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


@HiltAndroidApp
class App: Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { MovieRoomDatabase.getDatabase(this) }
    val repository by lazy { DataBaseRepositoryImpl(database.userDao()) }
}
