package com.example.moviesapp.domain.usecase.authentication.impl

import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.UserRepository
import com.example.moviesapp.domain.usecase.authentication.RegisterUserUseCase
import javax.inject.Inject

class RegisterUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    RegisterUserUseCase {

    override suspend operator fun invoke(userModel: UserModel){
        userRepository.insertUser(userModel)
    }
}