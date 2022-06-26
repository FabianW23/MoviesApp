package com.example.moviesapp.data.repository

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.datasource.remote.RemoteDataSource
import com.example.moviesapp.data.mapper.toListOfMovieModel
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.repository.AuthenticationRepository
import com.example.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    AuthenticationRepository {
    override fun singIn() {
        TODO("Not yet implemented")
    }

    override fun singOut() {
        TODO("Not yet implemented")
    }

}