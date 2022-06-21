package com.example.moviesapp.data.mapper

import com.example.moviesapp.data.datasource.remote.network.url.URL.IMAGES_URL
import com.example.moviesapp.data.model.dto.MovieDTO
import com.example.moviesapp.domain.model.MovieModel

fun MovieDTO.toMovieModel() = MovieModel(
    this.title ?: "",
    this.originalTitle ?: "",
    this.overview ?: "",
    IMAGES_URL + this.posterPath ?: "",
    IMAGES_URL + this.BackDropPath ?: "",
    this.releaseDate ?: "",
    this.voteAverage ?: 0.0
)

fun List<MovieDTO>.toListOfMovieModel() = this.map { it.toMovieModel() }
