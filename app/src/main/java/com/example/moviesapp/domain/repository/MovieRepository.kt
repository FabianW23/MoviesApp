package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.mapper.toListOfMovieModel
import com.example.moviesapp.domain.model.MovieModel

interface MovieRepository {
    fun getMovies():List<MovieModel>
}