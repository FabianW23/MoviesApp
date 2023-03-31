package com.example.moviesapp.domain.usecase.contact.impl

import android.content.Context
import com.example.moviesapp.domain.model.ContactModel
import com.example.moviesapp.domain.repository.ContactRepository
import com.example.moviesapp.domain.usecase.contact.GetContactListUseCase
import javax.inject.Inject

class GetContactListUseCaseImpl @Inject constructor(private val getContactRepository: ContactRepository): GetContactListUseCase {
    override suspend fun invoke(context: Context): List<ContactModel> {
        return getContactRepository.getContactList(context)
    }
}