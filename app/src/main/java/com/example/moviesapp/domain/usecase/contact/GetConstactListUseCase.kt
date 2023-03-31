package com.example.moviesapp.domain.usecase.contact

import android.content.Context
import com.example.moviesapp.domain.model.ContactModel

interface GetContactListUseCase {
    suspend operator fun invoke(context: Context) : List<ContactModel>
}