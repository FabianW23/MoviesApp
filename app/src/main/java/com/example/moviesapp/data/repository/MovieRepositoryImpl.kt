package com.example.moviesapp.data.repository

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.mapper.toListOfMovieModel
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val cacheDataSource: CacheDataSource) : MovieRepository{

    override fun getMovies():List<MovieModel>{
        return cacheDataSource.getMovies().toListOfMovieModel()
    }
}