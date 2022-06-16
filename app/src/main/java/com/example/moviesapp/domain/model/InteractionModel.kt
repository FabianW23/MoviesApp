package com.example.moviesapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InteractionModel(
    val title: String,
    val description: String,
    val count: Int
): Parcelable