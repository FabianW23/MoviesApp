package com.example.moviesapp.data.di

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.moviesapp.R
import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.datasource.cache.impl.CacheDataSourceImpl
import com.example.moviesapp.data.datasource.remote.RemoteDataSource
import com.example.moviesapp.data.datasource.remote.RemoteDataSourceImpl
import com.example.moviesapp.domain.model.UserModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideGoogleSingIn() =  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("1084680714992-j4fiikuc3vai0q3c2uc2b25np5504b86.apps.googleusercontent.com")
        .requestEmail()
        .build()

    /*@Singleton
    @Provides
    private fun googleLogIn(googleSignInOptions: GoogleSignInOptions, @ActivityContext context: Context) {
        var gsc = GoogleSignIn.getClient(context, googleSignInOptions)
        val intent = gsc?.signInIntent
        gsc?.signOut()
        return (context as Activity).startActivityForResult(intent, 100)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            if (requestCode == 100) {
                var task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.result
                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                saveUserLoggedIn(
                                    UserModel(
                                    0,
                                    account.displayName.toString(),
                                    account.email.toString(),
                                    "")
                                )
                                navigateToMenuActivity()
                            } else {
                                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT)
                            }
                        }
                }
            }

        } catch (e: ApiException) {
            Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT)
        }
    }*/
}