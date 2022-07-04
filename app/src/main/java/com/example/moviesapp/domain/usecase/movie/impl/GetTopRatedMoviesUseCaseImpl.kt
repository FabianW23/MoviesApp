package com.example.moviesapp.domain.usecase.movie.impl

import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.usecase.movie.GetTopRatedMoviesUseCase
import javax.inject.Inject

class GetTopRatedMoviesUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) :
    GetTopRatedMoviesUseCase {

    override suspend operator fun invoke(): List<MovieModel> {
        return movieRepository.getTopRatedMovies()
    }
}