package com.example.moviesapp.domain.model

sealed class Routes(val route: String){
    object SearchScreen:Routes("search_screen")
    object MovieScreen:Routes("movie_screen")
}