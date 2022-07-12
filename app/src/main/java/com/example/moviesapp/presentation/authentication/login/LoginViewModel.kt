package com.example.moviesapp.presentation.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import com.example.moviesapp.domain.usecase.validation.ValidateEmailFieldUseCase
import com.example.moviesapp.domain.usecase.validation.ValidatePasswordFieldUseCase
import com.example.moviesapp.domain.utils.HelperTexts
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val selectUserUseCase: SelectUserUseCase,
                                         val googleSignInOptions: GoogleSignInOptions,
                                         private val validatePasswordFieldUseCase: ValidatePasswordFieldUseCase,
                                         private val validateEmailFieldUseCase: ValidateEmailFieldUseCase) : ViewModel() {

    val isUserRegistered : MutableLiveData<UserModel> = MutableLiveData()
    var validEmail:Boolean = false
    var validPassword:Boolean = false

    fun validateUser(email: String, password: String) {
        viewModelScope.launch {
            val ifUserExist = selectUserUseCase(email, password)
            isUserRegistered.postValue(ifUserExist)
        }
    }

    fun validatePassword(password : String):String{
        val message = validatePasswordFieldUseCase(password)
        return if (message == HelperTexts.VALID.message){
            ""
        }else{
            message
        }
    }

    fun validateIfEmailIsValid(email : String):String{
        val message = validateEmailFieldUseCase(email)
        return if (message == HelperTexts.VALID.message){
            ""
        }else{
            message
        }
    }
}