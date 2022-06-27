package com.example.moviesapp.data.datasource.persistance.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user_table", indices = [Index(value = ["email"], unique = true)])
class UserEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String
)