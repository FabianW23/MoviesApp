package com.example.moviesapp.domain.usecase.string.impl

import com.example.moviesapp.domain.repository.StringRepository
import com.example.moviesapp.domain.usecase.string.ClearStringsUseCase
import javax.inject.Inject

class ClearStringsUseCaseImpl @Inject constructor(private val stringRepository: StringRepository): ClearStringsUseCase{
    override operator fun invoke(){
        stringRepository.clearStrings()
    }
}