package com.example.moviesapp.presentation.authentication.splash

import androidx.lifecycle.ViewModel
import com.example.moviesapp.domain.usecase.string.GetStringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val getStringUseCase: GetStringUseCase): ViewModel() {

    fun getString(id:String):String = getStringUseCase(id)
}