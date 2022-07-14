package com.example.moviesapp.domain.repository

interface StringRepository{

    fun putString(id: String, value: String)

    fun getString(id: String): String

    fun clearStrings()
}