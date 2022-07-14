package com.example.moviesapp.data.datasource.sharedpreferences

interface SharedPreferencesDataSource {
    fun putString(id:String,value:String)

    fun getString(id:String) : String

    fun clearStrings()
}