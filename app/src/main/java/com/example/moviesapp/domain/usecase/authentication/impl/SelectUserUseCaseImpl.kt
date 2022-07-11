package com.example.moviesapp.domain.usecase.authentication.impl

import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.UserRepository
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import javax.inject.Inject

class SelectUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) : SelectUserUseCase{

    override suspend operator fun invoke(email : String, password: String):UserModel?{
        return userRepository.selectUser(email,password)
    }
}