package com.example.moviesapp.domain.repository

interface AuthenticationRepository {
    fun singIn()

    fun singOut()
}