package com.example.moviesapp.presentation.authentication.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.AVATAR
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.EMAIL
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.NAME
import com.example.moviesapp.data.utils.toSha256
import com.example.moviesapp.databinding.FragmentLoginBinding
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.presentation.menu.MenuActivity
import com.example.moviesapp.presentation.utils.afterTextChanged
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isUserRegistered.observe(this, Observer(::localLogIn))
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
            viewModel.putString(NAME,user.name)
            viewModel.putString(EMAIL,user.email)
            user.avatar?.let { viewModel.putString(AVATAR, it) }
        }
    }

    private fun googleLogIn() {
        val gso = viewModel.googleSignInOptions
        val gsc = this.activity?.let { GoogleSignIn.getClient(it, gso) }
        val intent = gsc?.signInIntent
        gsc?.signOut()
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            if (requestCode == 100) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
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
                                    "",
                                    account.photoUrl.toString()))
                                navigateToMenuActivity()
                            } else {
                                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }

        } catch (e: ApiException) {
            Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
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
                binding.etUserEmailInput.text.toString(),
                binding.etPasswordInput.text.toString().toSha256())
        }

        validateForm()

        binding.fabGoogleLogin.setOnClickListener { googleLogIn() }
    }

    override fun onStart() {
        super.onStart()
        clearFields()
    }

    private fun clearFields() {
        binding.etPasswordInput.text?.clear()
        binding.etUserEmailInput.text?.clear()
        binding.etUserEmail.helperText = ""
        binding.etPassword.helperText = ""
    }

    private fun validateForm() {
        binding.etUserEmailInput.afterTextChanged { user -> binding.etUserEmail.helperText = viewModel.validateIfEmailIsValid(user)
            viewModel.validEmail = binding.etUserEmail.helperText.isNullOrEmpty()
            enableLoginButton()}
        binding.etPasswordInput.afterTextChanged { password -> binding.etPassword.helperText = viewModel.validatePassword(password)
            viewModel.validPassword = binding.etPassword.helperText.isNullOrEmpty()
            enableLoginButton()}
    }

    private fun enableLoginButton(){
        binding.btnLogin.isEnabled = viewModel.validEmail && viewModel.validPassword
    }

    private fun navigateToMenuActivity() {
        val intent = Intent(context, MenuActivity::class.java)
        startActivity(intent)
    }
}
