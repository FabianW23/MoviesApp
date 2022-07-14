package com.example.moviesapp.presentation.menu

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.forEachIndexed
import androidx.core.view.size
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMenuBinding
import com.example.moviesapp.presentation.authentication.login.LoginFragment
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.LOGGED_USER_PREFERENCES
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

    private lateinit var sharedPref : SharedPreferences
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        var navController = binding.navHostFragment.findNavController()
        binding.navView.setupWithNavController(navController)
        changeAccountTitleToUserName()
    }

    private fun changeAccountTitleToUserName() {
        sharedPref = this.getSharedPreferences(LOGGED_USER_PREFERENCES, Context.MODE_PRIVATE)!!
        val name = sharedPref.getString(NAME,null)
        if (name != null){
            var menu = binding.navView.menu.getItem(3)
            menu.title = name.substringBefore(" ")
        }
    }

}