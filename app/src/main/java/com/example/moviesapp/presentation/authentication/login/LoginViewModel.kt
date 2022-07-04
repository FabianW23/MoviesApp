package com.example.moviesapp.presentation.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.repository.UserRepository
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val selectUserUseCase: SelectUserUseCase, val googleSignInOptions: GoogleSignInOptions) : ViewModel() {

    val isUserEnableToLogin : MutableLiveData<UserModel> = MutableLiveData()

    fun validateUser(email: String, password: String) {
        viewModelScope.launch {
            val ifUserExist = selectUserUseCase(email, password)
            isUserEnableToLogin.postValue(ifUserExist)
        }
    }
}