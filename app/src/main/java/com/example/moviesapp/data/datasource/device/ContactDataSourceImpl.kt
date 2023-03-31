package com.example.moviesapp.data.datasource.device

import android.annotation.SuppressLint
import android.content.Context
import android.provider.ContactsContract
import com.example.moviesapp.domain.model.ContactModel
import javax.inject.Inject


class ContactDataSourceImpl @Inject constructor(): ContactDataSource {

    @SuppressLint("Range", "Recycle")
    override suspend fun getContactList(context:Context): List<ContactModel> {
        val contactList = ArrayList<ContactModel>()

        val phones = context.contentResolver?.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        try {

            while (phones!!.moveToNext()) {

                val name =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phoneNumber =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace(" ", "")
                val phonePhoto =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))

                val contact = ContactModel(phonePhoto, name, phoneNumber)
                if(contact.number.contains("+")) contactList.add(contact)
            }
        }catch (e:Exception){
            print(e.message)
        }

        return contactList.distinct()
    }
}