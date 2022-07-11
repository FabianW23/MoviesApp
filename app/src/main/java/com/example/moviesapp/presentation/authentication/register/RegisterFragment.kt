package com.example.moviesapp.presentation.authentication.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.moviesapp.App
import com.example.moviesapp.R
import com.example.moviesapp.data.utils.toSha256
import com.example.moviesapp.databinding.FragmentRegisterBinding
import com.example.moviesapp.domain.model.UserModel
import com.example.moviesapp.presentation.utils.afterTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isUserRegistered.observe(this, Observer(::checkIfUserIsRegistered))
    }

    private fun checkIfUserIsRegistered(user: UserModel?) {
        if (user == null){
            viewModel.insert(UserModel(0,
                binding.edNameInput.text.toString(),
                binding.edEmailInput.text.toString(),
                binding.edPasswordInput.text.toString().toSha256()))
            goBack()
        }else{
            Toast.makeText(context,getString(R.string.user_is_already_registered), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imBack.setOnClickListener {
            goBack()
        }

        binding.btnRegister.setOnClickListener {
                viewModel.validateUser(binding.edEmailInput.text.toString())
        }

        validateForm()
    }

    private fun goBack() {
        activity?.onBackPressed()
    }

    private fun validateForm() {
        binding.edNameInput.afterTextChanged { user -> viewModel.validName = viewModel.validateUserField(user)
            enableLoginButton()}
        binding.edEmailInput.afterTextChanged { user -> viewModel.validEmail = viewModel.validateUserField(user)
            enableLoginButton()}
        binding.edPasswordInput.afterTextChanged { password -> viewModel.validPassword = viewModel.validateUserField(password)
            enableLoginButton()}
    }

    private fun enableLoginButton(){
        binding.btnRegister.isEnabled = viewModel.validEmail && viewModel.validPassword && viewModel.validName
    }


}