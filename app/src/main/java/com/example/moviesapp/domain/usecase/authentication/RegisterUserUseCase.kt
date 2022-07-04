package com.example.moviesapp.domain.usecase.authentication

import com.example.moviesapp.domain.model.UserModel

interface RegisterUserUseCase {

    suspend operator fun invoke(userModel: UserModel)
}