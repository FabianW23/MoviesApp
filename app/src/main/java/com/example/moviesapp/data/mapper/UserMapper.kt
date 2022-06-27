package com.example.moviesapp.data.mapper

import com.example.moviesapp.presentation.authentication.database.entities.UserEntity
import com.example.moviesapp.domain.model.UserModel

fun UserModel.toUserEntity() = UserEntity(
    id = 0,
    email = this.email,
    name = this.name,
    password = this.password
)

//fun List<MovieDTO>.toListOfMovieModel() = this.map { it.toMovieModel() }
