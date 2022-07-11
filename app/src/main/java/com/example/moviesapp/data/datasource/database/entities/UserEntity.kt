package com.example.moviesapp.data.datasource.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    val name: String,
    val email: String,
    val password: String
)