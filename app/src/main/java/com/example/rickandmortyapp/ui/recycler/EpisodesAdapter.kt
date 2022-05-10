package com.example.rickandmortyapp.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.models.EpisodeModel

class EpisodesAdapter: RecyclerView.Adapter<EpisodesHolder>() {

    private val list: MutableList<EpisodeModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodesHolder(parent)

    override fun onBindViewHolder(holder: EpisodesHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount() = list.size

    fun setData(getLists: List<EpisodeModel>){
        list.addAll(getLists)
    }

    fun getData() = list

}