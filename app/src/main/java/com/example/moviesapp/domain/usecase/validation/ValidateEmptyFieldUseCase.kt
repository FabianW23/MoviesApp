package com.example.moviesapp.domain.usecase.validation

interface ValidateEmptyFieldUseCase {

    operator fun invoke(text : String): Boolean
}