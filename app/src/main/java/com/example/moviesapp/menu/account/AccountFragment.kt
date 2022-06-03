package com.example.moviesapp.menu.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentAccountBinding
import com.example.moviesapp.menu.account.adapter.model.ProfileData
import com.example.moviesapp.menu.search.adapter.MovieAdapter
import com.example.moviesapp.menu.search.adapter.ProfileListsAdapter

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding

    private val data = listOf(ProfileData("Calificaciones","Calificar y obtener recomendaciones"),
                            ProfileData("Listas","Agregar a listas"),
                            ProfileData("Comentarios","Agregar comentarios"))

    private fun initRecycler(){
        binding.rvProfileData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var adapter = ProfileListsAdapter(data)
        binding.rvProfileData.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAccountBinding.inflate(inflater, container, false)
        initRecycler()
        return binding.root
    }

}