package com.example.moviesapp.domain.repository

import com.example.moviesapp.domain.model.InteractionModel

interface InteractionRepository{
    fun getInteractions():List<InteractionModel>
}