package com.example.moviesapp.presentation.menu.account.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentRegisterBinding
import com.example.moviesapp.databinding.ProfileDataItemBinding
import com.example.moviesapp.domain.model.InteractionModel

class ProfileListsAdapter(private val profileData:List<InteractionModel>):RecyclerView.Adapter<ProfileListsAdapter.ProfileListHolder>() {

    lateinit var binding: ProfileDataItemBinding

    inner class ProfileListHolder(val view:View):RecyclerView.ViewHolder(view){

        //private val tvRatings:TextView = view.findViewById(R.id.tvTitle)
        //private val tvDescription:TextView = view.findViewById(R.id.tvDescription)
        //private val tvCount:TextView = view.findViewById(R.id.tvCount)

        fun render(interactionModel: InteractionModel){
            binding.tvTitle.text = interactionModel.title
            binding.tvDescription.text = interactionModel.description
            binding.tvCount.text = interactionModel.count.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ProfileDataItemBinding.inflate(layoutInflater, parent, false)
        return ProfileListHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ProfileListHolder, position: Int) {
        holder.render(profileData[position])
    }

    override fun getItemCount(): Int {
        return profileData.size
    }
}