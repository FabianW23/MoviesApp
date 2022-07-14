package com.example.moviesapp.data.repository

import com.example.moviesapp.data.datasource.sharedpreferences.SharedPreferencesDataSource
import com.example.moviesapp.domain.repository.StringRepository
import javax.inject.Inject

class StringRepositoryImpl @Inject constructor(private val sharedPreferencesDataSource: SharedPreferencesDataSource) : StringRepository{

    override fun putString(id: String, value: String){
        sharedPreferencesDataSource.putString(id,value)
    }

    override fun getString(id: String): String{
        return sharedPreferencesDataSource.getString(id)
    }

    override fun clearStrings() {
        sharedPreferencesDataSource.clearStrings()
    }
}