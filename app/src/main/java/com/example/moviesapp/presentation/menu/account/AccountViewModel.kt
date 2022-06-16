package com.example.moviesapp.presentation.menu.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.domain.usecase.GetInteractionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val getInteractionsUseCase: GetInteractionsUseCase) : ViewModel() {

    val interactionList : MutableLiveData<List<InteractionModel>> = MutableLiveData()

    fun getInteractions(){
        val interactions = getInteractionsUseCase()
        interactionList.value = interactions
    }
}