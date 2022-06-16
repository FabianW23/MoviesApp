package com.example.moviesapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val name:String,
    val date:String,
    val actors:String,
    val score:Double,
    val synopsis:String,
    val genre:String,
    val poster:String,
    val trailer:String
    ) : Parcelable