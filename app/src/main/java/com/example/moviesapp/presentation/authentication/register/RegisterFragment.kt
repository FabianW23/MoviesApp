package com.example.moviesapp.presentation.authentication.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moviesapp.App
import com.example.moviesapp.data.utils.toSha256
import com.example.moviesapp.databinding.FragmentRegisterBinding
import com.example.moviesapp.domain.model.UserModel


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

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
            if(validateFields()){
                viewModel.insert(UserModel(0,
                    binding.edNameInput.text.toString(),
                    binding.edEmailInput.text.toString(),
                    binding.edPasswordInput.text.toString().toSha256()))
                goBack()
            }
        }
        /*viewModel.allWords.observe(viewLifecycleOwner) { words ->
            // Update the cached copy of the words in the adapter.
            print(words)
        }*/
    }

    private fun goBack() {
        activity?.onBackPressed()
    }

    private fun validateFields() : Boolean {
        var enableRegister = false
        enableRegister = binding.edNameInput.text != null
        enableRegister = binding.edEmailInput.text != null
        enableRegister = binding.edPasswordInput.text != null
        return enableRegister
    }


}