package com.example.moviesapp.data.model.dto

data class MovieCollectionDTO(
    val created_by: String?,
    val description: String?,
    val favorite_count: Int?,
    val id: Int?,
    val items: List<MovieDTO>? = listOf()
)