package com.example.moviesapp.presentation.authentication.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.data.utils.toSha256
import com.example.moviesapp.databinding.FragmentLoginBinding
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.presentation.menu.MenuActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var sharedPref : SharedPreferences
    private lateinit var binding: FragmentLoginBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = activity?.getSharedPreferences(LOGGED_USER_PREFERENCES,Context.MODE_PRIVATE)!!
        //checkIfUserIsLoggedIn()
        viewModel.isUserEnableToLogin.observe(this, Observer(::localLogIn))
    }

    private fun checkIfUserIsLoggedIn() {
        val name = sharedPref?.getString(NAME,null)
        if (name != null){
            navigateToMenuActivity()
        }
    }

    private fun localLogIn(user: UserModel?) {
        if (user != null)
        {
            saveUserLoggedIn(user)
            navigateToMenuActivity()

        }else{
            Toast.makeText(this.activity,"Login Failed",Toast.LENGTH_LONG).show()
        }
    }

    private fun saveUserLoggedIn(user: UserModel?) {
        if (user != null) {
            val editPrefs = sharedPref?.edit()
            editPrefs?.putInt(ID,user.id)
            editPrefs?.putString(NAME,user.name)
            editPrefs?.putString(EMAIL,user.email)
            editPrefs?.apply()
            editPrefs?.commit()
        }
    }

    private fun googleLogIn() {
        var gso = viewModel.googleSignInOptions
        var gsc = this.activity?.let { GoogleSignIn.getClient(it, gso) }
        val intent = gsc?.signInIntent
        gsc?.signOut()
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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
                                saveUserLoggedIn(UserModel(
                                    0,
                                    account.displayName.toString(),
                                    account.email.toString(),
                                    ""))
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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRevister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.validateUser(
                binding.etUser.text.toString(),
                binding.etPassword.text.toString().toSha256())
        }

        binding.etUser.afterTextChanged { user -> print(user) }

        binding.fabGoogleLogin.setOnClickListener { googleLogIn() }
    }

    private fun navigateToMenuActivity() {
        var intent = Intent(context, MenuActivity::class.java)
        startActivity(intent)
    }

    companion object{
        const val LOGGED_USER_PREFERENCES = "com.example.moviesapp.LOGED_USER_PREFERENCES"
        const val EMAIL = "email"
        const val NAME = "name"
        const val ID = "id"
    }
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}