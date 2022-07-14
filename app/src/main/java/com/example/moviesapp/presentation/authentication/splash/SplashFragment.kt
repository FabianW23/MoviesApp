package com.example.moviesapp.presentation.authentication.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.data.datasource.sharedpreferences.constants.SharedPreferences.NAME
import com.example.moviesapp.databinding.FragmentSplashBinding
import com.example.moviesapp.presentation.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel : SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val name = viewModel.getString(NAME)
        if (name != ""){
            navigateToMenuActivity()
        }else{
            goToLoginScreen()
        }
    }

    private fun goToLoginScreen(){
        Handler(Looper.getMainLooper()).postDelayed({
            val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            findNavController().navigate(action)
        }, 2000)
    }

    private fun navigateToMenuActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(context, MenuActivity::class.java)
            startActivity(intent)
        }, 2000)

    }
}