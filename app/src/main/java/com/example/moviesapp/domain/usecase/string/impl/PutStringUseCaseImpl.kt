package com.example.moviesapp.domain.usecase.string.impl

import com.example.moviesapp.domain.repository.StringRepository
import com.example.moviesapp.domain.usecase.string.PutStringUseCase
import javax.inject.Inject

class PutStringUseCaseImpl @Inject constructor(private val stringRepository: StringRepository): PutStringUseCase{
    override operator fun invoke(id: String, value: String) {
        stringRepository.putString(id,value)
    }
}