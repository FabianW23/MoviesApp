package com.example.moviesapp.presentation.authentication.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.App
import com.example.moviesapp.data.mapper.toUserEntity
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.presentation.authentication.database.DataBaseRepositoryImpl
import com.example.moviesapp.presentation.authentication.database.entities.UserEntity
import kotlinx.coroutines.launch

class RegisterViewModel(private val dataBaseRepositoryImpl: DataBaseRepositoryImpl) : ViewModel(){

    //val allWords: LiveData<List<UserEntity>> = dataBaseRepositoryImpl.allWords

    fun insert(userModel: UserModel) = viewModelScope.launch {
        dataBaseRepositoryImpl.insertUser(userModel)
    }
}

class RegisterViewModelFactory(private val repository: DataBaseRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}