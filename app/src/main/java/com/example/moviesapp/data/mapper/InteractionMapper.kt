package com.example.moviesapp.data.mapper

import com.example.moviesapp.data.model.dto.InteractionDTO
import com.example.moviesapp.domain.model.InteractionModel

fun InteractionDTO.toInteractionModel():InteractionModel = InteractionModel(this.title, this.description,this.count)


fun List<InteractionDTO>.toListOfInteractionModel():List<InteractionModel> = this.map { it.toInteractionModel() }