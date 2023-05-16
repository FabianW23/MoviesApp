package com.example.moviesapp.presentation.menu.search.share

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.presentation.di.IoDispatcher
import com.example.moviesapp.domain.model.ContactModel
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.domain.usecase.contact.GetContactListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShareMovieViewModel @Inject constructor(
    private val getContactListUseCase: GetContactListUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher) : ViewModel(){

    val contactList : MutableLiveData<List<ContactModel>> = MutableLiveData()

    private var matchedContactList = listOf<ContactModel>()
    val query = MutableLiveData("")

    fun getContactList(context:Context){
        viewModelScope.launch(dispatcher) {
            matchedContactList = getContactListUseCase(context)!!
            contactList.postValue(matchedContactList)
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
        viewModelScope.launch(dispatcher){
            if(query.isEmpty()){
                contactList.postValue(matchedContactList)
            }else{
                contactList.postValue( matchedContactList.filter { it.name.contains(query, ignoreCase = true) } )
            }
        }

    }
}