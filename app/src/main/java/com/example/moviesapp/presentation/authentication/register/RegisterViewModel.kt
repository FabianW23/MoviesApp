package com.example.moviesapp.presentation.authentication.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.repository.UserRepositoryImpl
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.domain.usecase.authentication.RegisterUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val registerUserUseCase: RegisterUserUseCase) : ViewModel(){

    //val allWords: LiveData<List<UserEntity>> = dataBaseRepositoryImpl.allWords

    fun insert(userModel: UserModel) = viewModelScope.launch {
        registerUserUseCase(userModel)
    }
}

/*class RegisterViewModelFactory(private val repository: DataBaseRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/