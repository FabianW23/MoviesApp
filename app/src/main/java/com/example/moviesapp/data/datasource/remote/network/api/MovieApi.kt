package com.example.moviesapp.data.datasource.remote.network.api

import com.example.moviesapp.data.model.dto.MovieCollectionDTO
import com.example.moviesapp.data.datasource.remote.network.url.URL
import com.example.moviesapp.data.datasource.remote.network.url.URL.API_KEY
import com.example.moviesapp.data.model.dto.TopRatedCollectionDTO
import retrofit2.http.GET

interface MovieApi {
    @GET(URL.COLLECTION_MOVIES_ENDPOINT + API_KEY)
    suspend fun getCollectionMovies(): MovieCollectionDTO

    @GET(URL.TOP_RATED_MOVIES_ENDPOINT + API_KEY)
    suspend fun getTopRatedMovies(): TopRatedCollectionDTO
}