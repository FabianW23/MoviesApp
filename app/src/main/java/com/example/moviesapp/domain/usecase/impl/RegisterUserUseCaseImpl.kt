package com.example.moviesapp.domain.usecase.impl

import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.DataBaseRepository
import com.example.moviesapp.domain.usecase.RegisterUserUseCase
import javax.inject.Inject

class RegisterUserUseCaseImpl @Inject constructor(private val dataBaseRepository: DataBaseRepository) : RegisterUserUseCase {

    override suspend operator fun invoke(userModel: UserModel){
        dataBaseRepository.insertUser(userModel)
    }
}