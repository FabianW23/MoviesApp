package com.example.moviesapp.data.datasource.remote

import com.example.moviesapp.data.model.dto.MovieDTO


interface RemoteDataSource {

    suspend fun getMovies():List<MovieDTO>

    suspend fun getTopRatedMovies():List<MovieDTO>
}