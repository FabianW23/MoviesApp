package com.example.moviesapp.menu.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.menu.account.adapter.model.ProfileData

class ProfileListsAdapter(val profileData:List<ProfileData>):RecyclerView.Adapter<ProfileListsAdapter.ProfileListHolder>() {

    class ProfileListHolder(val view:View):RecyclerView.ViewHolder(view){

        private val tvRatings:TextView = view.findViewById(R.id.tvTitle)
        private val tvDescription:TextView = view.findViewById(R.id.tvDescription)

        fun render(profileData: ProfileData){
            tvRatings.text = profileData.title
            tvDescription.text = profileData.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProfileListHolder(layoutInflater.inflate(R.layout.profile_data_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProfileListHolder, position: Int) {
        holder.render(profileData[position])
    }

    override fun getItemCount(): Int {
        return profileData.size
    }
}