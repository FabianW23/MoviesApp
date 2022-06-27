package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.model.UserModel

interface RegisterUserUseCase {

    suspend operator fun invoke(userModel: UserModel)
}