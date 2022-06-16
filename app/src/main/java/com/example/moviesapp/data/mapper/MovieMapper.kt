package com.example.moviesapp.data.mapper

import com.example.moviesapp.data.model.dto.MovieDTO
import com.example.moviesapp.domain.model.MovieModel

fun MovieDTO.toMovieModel() = MovieModel(
    this.name ?: "",
    this.date ?: "",
    this.actors ?: "",
    this.score ?: 0.0,
    this.synopsis ?: "",
    this.genre ?: "",
    this.poster ?: "",
    this.trailer ?: "",
)

fun List<MovieDTO>.toListOfMovieModel() = this.map { it.toMovieModel() }
