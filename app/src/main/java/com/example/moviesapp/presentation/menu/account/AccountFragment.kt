package com.example.moviesapp.presentation.menu.account

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentAccountBinding
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.presentation.menu.account.adapter.ProfileListsAdapter
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.AVATAR
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.LOGGED_USER_PREFERENCES
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.NAME
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
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
        val adapter = ProfileListsAdapter(interactions)
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
        if (viewModel.getString(NAME) != "") {
            binding.tvUserName.text = viewModel.getString(NAME)
            val avatar = viewModel.getString(AVATAR)
            if (avatar != ""){
                Picasso.get().load(avatar).into(binding.imAvatar)
            }else{
                binding.tvAvatar.isVisible = true
                binding.tvAvatar.text = (viewModel.getString(NAME)).first().toString()
            }
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
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client))
            .requestEmail()
            .build()
        val gsc = this.activity?.let {
            GoogleSignIn.getClient(it, gso)}
        gsc?.signOut()?.addOnCompleteListener {
            Toast.makeText(context, getString(R.string.logging_out), Toast.LENGTH_SHORT).show()
            clearPreferences()
            activity?.finish()
        }
    }

    private fun clearPreferences() {
        viewModel.clearString()
    }
}


