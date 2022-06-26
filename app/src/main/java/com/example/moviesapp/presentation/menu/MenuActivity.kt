package com.example.moviesapp.presentation.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.size
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

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
        var menu = binding.navView.getChildAt(3)
    }

}