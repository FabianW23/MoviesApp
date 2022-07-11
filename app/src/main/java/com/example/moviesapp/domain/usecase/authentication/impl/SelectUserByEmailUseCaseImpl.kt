package com.example.moviesapp.domain.usecase.authentication.impl

import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.UserRepository
import com.example.moviesapp.domain.usecase.authentication.SelectUserByEmailUseCase
import javax.inject.Inject

class SelectUserByEmailUseCaseImpl @Inject constructor(private val userRepository: UserRepository) : SelectUserByEmailUseCase{

    override suspend operator fun invoke(email : String):UserModel?{
        return userRepository.selectUserByEmail(email)
    }
}