package com.example.moviesapp.data.datasource.cache

import com.example.moviesapp.data.model.dto.InteractionDTO
import com.example.moviesapp.data.model.dto.MovieDTO

interface CacheDataSource {

    fun getMovies():List<MovieDTO>

    fun getInteractions():List<InteractionDTO>
}