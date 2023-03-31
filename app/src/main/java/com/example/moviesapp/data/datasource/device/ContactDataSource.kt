package com.example.moviesapp.data.datasource.device

import android.content.Context
import com.example.moviesapp.domain.model.ContactModel

interface ContactDataSource {
    suspend fun getContactList(context: Context): List<ContactModel>
}