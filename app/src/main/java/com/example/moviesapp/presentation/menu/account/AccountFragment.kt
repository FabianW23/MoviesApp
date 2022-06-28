package com.example.moviesapp.presentation.menu.account

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentAccountBinding
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.presentation.authentication.AuthenticationActivity
import com.example.moviesapp.presentation.authentication.login.LoginFragment.Companion.LOGGED_USER_PREFERENCES
import com.example.moviesapp.presentation.authentication.login.LoginFragment.Companion.NAME
import com.example.moviesapp.presentation.menu.account.adapter.ProfileListsAdapter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private lateinit var sharedPref : SharedPreferences
    private lateinit var binding: FragmentAccountBinding
    private val viewModel: AccountViewModel by viewModels()
    private lateinit var interactions: List<InteractionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = activity?.getSharedPreferences(LOGGED_USER_PREFERENCES,Context.MODE_PRIVATE)!!
        viewModel.interactionList.observe(this, Observer(::setInteractionList))
    }

    private fun initRecycler() {
        binding.rvProfileData.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var adapter = ProfileListsAdapter(interactions)
        binding.rvProfileData.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        printUserData()
        return binding.root
    }

    private fun printUserData() {
        if (sharedPref.getString(NAME,null) != null) {
            binding.tvUserName.text = sharedPref.getString(NAME,"user")
            //Picasso.get().load(account.photoUrl).into(binding.imAvatar)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getInteractions()

        binding.btnConfigurations.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            googleLogOut()
        }
    }

    private fun setInteractionList(interactions: List<InteractionModel>?) {
        if (interactions != null) {
            this.interactions = interactions
            initRecycler()
        }
    }

    private fun googleLogOut() {
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        var gsc = this.activity?.let {
            GoogleSignIn.getClient(it, gso)}
        gsc?.signOut()?.addOnCompleteListener {
            //val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(context, "Logging Out", Toast.LENGTH_SHORT)
            //startActivity(intent)
            clearPreferences()
            activity?.finish()
        }
    }

    private fun clearPreferences() {
        sharedPref?.edit()?.clear()?.commit()
    }
}


