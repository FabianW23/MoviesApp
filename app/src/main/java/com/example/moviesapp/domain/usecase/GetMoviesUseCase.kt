package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.domain.model.MovieModel

interface GetMoviesUseCase {

    suspend operator fun invoke():List<MovieModel>
}