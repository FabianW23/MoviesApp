package com.example.moviesapp.domain.usecase.movie.impl

import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.usecase.movie.GetMoviesUseCase
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) :
    GetMoviesUseCase {

    override suspend operator fun invoke():List<MovieModel>{
        return movieRepository.getMovies()
    }
}