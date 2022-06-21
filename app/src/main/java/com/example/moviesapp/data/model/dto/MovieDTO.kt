package com.example.moviesapp.data.model.dto

import com.google.gson.annotations.SerializedName

data class MovieDTO (
    @SerializedName("title")
    val title: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val BackDropPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?
)