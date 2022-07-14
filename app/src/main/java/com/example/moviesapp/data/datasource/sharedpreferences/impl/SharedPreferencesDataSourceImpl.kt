package com.example.moviesapp.data.datasource.sharedpreferences.impl

import android.content.SharedPreferences
import com.example.moviesapp.data.datasource.sharedpreferences.SharedPreferencesDataSource
import javax.inject.Inject

class SharedPreferencesDataSourceImpl @Inject constructor(private val sharedPreferences: SharedPreferences): SharedPreferencesDataSource {

    override fun putString(id: String, value: String) {
        val edit = sharedPreferences.edit()
        edit.putString(id,value)
        edit.apply()
    }

    override fun getString(id: String): String {
        return sharedPreferences.getString(id,"").toString()
    }

    override fun clearStrings() {
        sharedPreferences.edit().clear().apply()
    }
}