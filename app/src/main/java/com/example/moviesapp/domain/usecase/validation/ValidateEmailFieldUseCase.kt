package com.example.moviesapp.domain.usecase.validation

interface ValidateEmailFieldUseCase {

    operator fun invoke(text : String): String
}