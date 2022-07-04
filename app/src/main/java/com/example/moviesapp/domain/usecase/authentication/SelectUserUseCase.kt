package com.example.moviesapp.domain.usecase.authentication

import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.model.UserModel

interface SelectUserUseCase {

    suspend operator fun invoke(email : String, password: String):UserModel?
}