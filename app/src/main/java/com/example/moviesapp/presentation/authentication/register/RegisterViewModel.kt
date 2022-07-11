package com.example.moviesapp.presentation.authentication.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.repository.UserRepositoryImpl
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.usecase.authentication.RegisterUserUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserByEmailUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val selectUserByEmailUseCase: SelectUserByEmailUseCase,
                                            private val registerUserUseCase: RegisterUserUseCase) : ViewModel(){

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

    fun validateUserField(field : String):Boolean{
        return field != ""
    }
}
