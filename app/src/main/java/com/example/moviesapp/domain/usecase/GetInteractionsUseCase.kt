package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.repository.InteractionRepositoryImpl
import com.example.moviesapp.domain.model.InteractionModel

interface GetInteractionsUseCase {
    operator fun invoke():List<InteractionModel>
}