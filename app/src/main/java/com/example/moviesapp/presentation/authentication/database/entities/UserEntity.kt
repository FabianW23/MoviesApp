package com.example.moviesapp.presentation.authentication.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    val name: String,
    val email: String,
    val password: String
)