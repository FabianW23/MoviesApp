package com.example.moviesapp.presentation.authentication.login

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val selectUserUseCase: SelectUserUseCase,
                                         val googleSignInOptions: GoogleSignInOptions,
                                         private val validateEmptyFieldUseCase: ValidateEmptyFieldUseCase) : ViewModel() {

    val isUserRegistered : MutableLiveData<UserModel> = MutableLiveData()
    var validEmail:Boolean = false
    var validPassword:Boolean = false

    fun validateUser(email: String, password: String) {
        viewModelScope.launch {
            val ifUserExist = selectUserUseCase(email, password)
            isUserRegistered.postValue(ifUserExist)
        }
    }

    fun validateIfFieldIsEmpty(text : String):Boolean{
        return validateEmptyFieldUseCase.invoke(text)
    }

    fun validateIfEmailIsValid(email : String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}