package com.example.moviesapp.data.datasource.remote

import com.example.moviesapp.data.datasource.remote.network.api.MovieApi
import com.example.moviesapp.data.model.dto.MovieDTO
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MovieApi): RemoteDataSource {

    override suspend fun getMovies(): List<MovieDTO> {
        return  api.getCollectionMovies().items ?: listOf()
    }

    override suspend fun getTopRatedMovies(): List<MovieDTO> {
        return api.getTopRatedMovies().results ?: listOf()
    }
}