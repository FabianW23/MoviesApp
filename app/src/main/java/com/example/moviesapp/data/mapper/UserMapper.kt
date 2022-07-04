package com.example.moviesapp.data.mapper

import com.example.moviesapp.data.datasource.database.entities.UserEntity
import com.example.moviesapp.domain.model.UserModel

fun UserModel.toUserEntity() = UserEntity(
    id = this.id,
    email = this.email,
    name = this.name,
    password = this.password
)

fun UserEntity.toUserModelWithOutPassword() = UserModel(
    id = this.id ?: 0,
    email = this.email,
    name = this.name,
    password = ""
)
