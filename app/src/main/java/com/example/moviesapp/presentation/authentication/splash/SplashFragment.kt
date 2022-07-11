package com.example.moviesapp.presentation.authentication.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.databinding.FragmentSplashBinding
import com.example.moviesapp.presentation.menu.MenuActivity
import com.example.moviesapp.presentation.utils.constants.SharedPreferences.LOGGED_USER_PREFERENCES
import com.example.moviesapp.presentation.utils.constants.SharedPreferences.NAME

class SplashFragment : Fragment() {

    private lateinit var sharedPref : SharedPreferences
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
        sharedPref = activity?.getSharedPreferences(LOGGED_USER_PREFERENCES, Context.MODE_PRIVATE)!!
        val name = sharedPref?.getString(NAME,null)
        if (name != null){
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
            var intent = Intent(context, MenuActivity::class.java)
            startActivity(intent)
        }, 2000)

    }
}