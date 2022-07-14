package com.example.moviesapp.domain.usecase.string

interface PutStringUseCase {
    operator fun invoke(id: String, value: String)
}