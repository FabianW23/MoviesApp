package com.example.moviesapp.data.repository

import android.content.Context
import com.example.moviesapp.data.datasource.device.ContactDataSource
import com.example.moviesapp.domain.model.ContactModel
import com.example.moviesapp.domain.repository.ContactRepository
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(private val contactDataSource: ContactDataSource) : ContactRepository {
    override suspend fun getContactList(context: Context): List<ContactModel> {
        return contactDataSource.getContactList(context)
    }
}