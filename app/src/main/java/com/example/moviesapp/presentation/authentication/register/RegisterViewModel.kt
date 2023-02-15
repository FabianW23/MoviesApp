package com.example.moviesapp.presentation.authentication.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.repository.UserRepositoryImpl
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.usecase.authentication.RegisterUserUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserByEmailUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import com.example.moviesapp.domain.usecase.validation.ValidateEmailFieldUseCase
import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase
import com.example.moviesapp.domain.usecase.validation.ValidatePasswordFieldUseCase
import com.example.moviesapp.domain.utils.HelperTexts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val selectUserByEmailUseCase: SelectUserByEmailUseCase,
                                            private val registerUserUseCase: RegisterUserUseCase,
                                            private val validateEmptyFieldUseCase: ValidateEmptyFieldUseCase,
                                            private val validatePasswordFieldUseCase: ValidatePasswordFieldUseCase,
                                            private val validateEmailFieldUseCase: ValidateEmailFieldUseCase) : ViewModel(){

    val isUserRegistered : MutableLiveData<UserModel> = MutableLiveData()
    var validName:Boolean = false
    var validEmail:Boolean = false
    var validPassword:Boolean = false

    fun insert(userModel: UserModel) = viewModelScope.launch {
        registerUserUseCase(userModel)
    }

    fun validateUser(email: String) {
        viewModelScope.launch {
            val ifUserExist = selectUserByEmailUseCase(email)
            isUserRegistered.postValue(ifUserExist)
        }
    }

    fun validateUserField(user : String):String{
        val message = validateEmptyFieldUseCase(user)
        return if (message == HelperTexts.VALID.message){
            ""
        }else{
            message
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
