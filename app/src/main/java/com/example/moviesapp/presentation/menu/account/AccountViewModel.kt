package com.example.moviesapp.presentation.menu.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.usecase.interaction.GetInteractionsUseCase
import com.example.moviesapp.domain.usecase.string.ClearStringsUseCase
import com.example.moviesapp.domain.usecase.string.GetStringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val getInteractionsUseCase: GetInteractionsUseCase,
                                           private val getStringUseCase: GetStringUseCase,
                                           private val clearStringsUseCase: ClearStringsUseCase) : ViewModel() {

    val interactionList : MutableLiveData<List<InteractionModel>> = MutableLiveData()

    fun getInteractions(){
        val interactions = getInteractionsUseCase()
        interactionList.value = interactions
    }

    fun getString(id:String):String = getStringUseCase(id)

    fun clearString() {
        clearStringsUseCase()
    }
}