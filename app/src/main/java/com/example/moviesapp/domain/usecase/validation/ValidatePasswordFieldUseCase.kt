package com.example.moviesapp.domain.usecase.validation

interface ValidatePasswordFieldUseCase {

    operator fun invoke(text : String): String
}