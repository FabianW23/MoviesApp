package com.example.moviesapp.data.datasource.remote

import com.example.moviesapp.data.service.FireBaseAuthenticationService

class RemoteFireBaseDataSourceImpl constructor(private val fireBaseAuthenticationService: FireBaseAuthenticationService): RemoteFireBaseDataSource{
    override fun singIn() {
        fireBaseAuthenticationService.singIn()
    }

    override fun singOut() {
        fireBaseAuthenticationService.singOut()
    }
}