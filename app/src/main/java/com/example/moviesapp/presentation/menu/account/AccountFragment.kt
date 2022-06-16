package com.example.moviesapp.presentation.menu.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.databinding.FragmentAccountBinding
import com.example.moviesapp.domain.model.InteractionModel
import com.example.moviesapp.presentation.menu.account.adapter.ProfileListsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private val viewModel : AccountViewModel by viewModels()
    private lateinit var interactions : List<InteractionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.interactionList.observe(this, Observer(::setInteractionList))
    }

    private fun initRecycler(){
        binding.rvProfileData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var adapter = ProfileListsAdapter(interactions)
        binding.rvProfileData.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getInteractions()
    }

    private fun setInteractionList(interactions: List<InteractionModel>?) {
        if (interactions != null) {
            this.interactions = interactions
            initRecycler()
        }
    }
}


