package com.example.moviesapp.data.service

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.moviesapp.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class FireBaseAuthenticationServiceImpl @Inject constructor(@ActivityContext private val context: Context) : FireBaseAuthenticationService{


    override fun singIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //default_web_client_id
            .requestIdToken(context.getString(R.string.default_web_client))
            .requestEmail()
            .build()
        val activity = context as Activity
        val gsc = GoogleSignIn.getClient(activity, gso)
        val intent = gsc.signInIntent
        gsc.signOut()
        startActivityForResult(activity, intent, 100, null)
    }

    fun processResponseLogIn(requestCode: Int, resultCode: Int, data: Intent?)// : Boolean
    {
        try {
            if (requestCode == 100) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.result
                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                    //return true
                }
            }

        } catch (e: ApiException) {
            Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
            //return false
        }
    }

    override fun singOut() {
        TODO("Not yet implemented")
    }
}