package com.example.moviesapp.domain.usecase.authentication

import com.example.moviesapp.domain.model.UserModel

interface SelectUserByEmailUseCase {

    suspend operator fun invoke(email : String):UserModel?
}