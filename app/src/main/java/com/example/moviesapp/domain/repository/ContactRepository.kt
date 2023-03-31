package com.example.moviesapp.domain.repository

import android.content.Context
import com.example.moviesapp.domain.model.ContactModel

interface ContactRepository {
    suspend fun getContactList(context: Context) : List<ContactModel>
}