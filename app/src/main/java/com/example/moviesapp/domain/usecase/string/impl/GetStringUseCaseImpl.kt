package com.example.moviesapp.domain.usecase.string.impl

import com.example.moviesapp.domain.repository.StringRepository
import com.example.moviesapp.domain.usecase.string.GetStringUseCase
import javax.inject.Inject

class GetStringUseCaseImpl @Inject constructor(private val stringRepository: StringRepository): GetStringUseCase{
    override operator fun invoke(id: String): String {
        return stringRepository.getString(id)
    }
}