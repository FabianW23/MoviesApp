package com.example.moviesapp.domain.usecase.string

interface GetStringUseCase {
    operator fun invoke(id: String): String
}