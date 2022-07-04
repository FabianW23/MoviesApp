package com.example.moviesapp.domain.usecase.interaction.impl

import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.repository.InteractionRepository
import com.example.moviesapp.domain.usecase.interaction.GetInteractionsUseCase
import javax.inject.Inject

class GetInteractionsUseCaseImpl @Inject constructor(private val interactionRepository: InteractionRepository) :
    GetInteractionsUseCase {
    override operator fun invoke():List<InteractionModel>{
        return interactionRepository.getInteractions()
    }
}