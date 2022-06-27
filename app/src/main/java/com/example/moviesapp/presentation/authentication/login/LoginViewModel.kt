package com.example.moviesapp.presentation.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.presentation.authentication.database.DataBaseRepositoryImpl
import com.example.moviesapp.presentation.authentication.register.RegisterViewModel
import kotlinx.coroutines.launch

class LoginViewModel(private val dataBaseRepositoryImpl: DataBaseRepositoryImpl) : ViewModel() {

    val isUserEnableToLogin : MutableLiveData<Boolean> = MutableLiveData()

    fun validateUser(email: String, password: String) {
        viewModelScope.launch {
            val ifUserExist = dataBaseRepositoryImpl.ifUserExist(email, password)
            isUserEnableToLogin.postValue(ifUserExist)
        }
    }
}

class LoginViewModelFactory(private val repository: DataBaseRepositoryImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}