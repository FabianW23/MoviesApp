package com.example.moviesapp.domain.usecase

import com.example.moviesapp.domain.model.MovieModel

interface GetTopRatedMoviesUseCase{

    suspend operator fun invoke(): List<MovieModel>
}