package com.example.moviesapp.domain.usecase.validation.Impl

import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase

class ValidateEmptyFieldImpl : ValidateEmptyFieldUseCase {
    override fun invoke(text: String): Boolean {
        return text != ""
    }
}