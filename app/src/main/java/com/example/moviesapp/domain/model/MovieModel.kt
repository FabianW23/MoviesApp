package com.example.moviesapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val title: String,
    val originalTitle: String,
    val overview: String,
    val posterUrlPath: String,
    val BackDropPath: String?,
    val releaseDate: String?,
    val voteAverage: Double?
) : Parcelable