package com.example.moviesapp.data.model.dto

data class TopRatedCollectionDTO(
    val page: String?,
    val results: List<MovieDTO>? = listOf()
)