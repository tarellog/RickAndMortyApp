package com.example.rickandmortyapp.feature.episodescreen.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.BaseModel

class EpisodesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<BaseModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when(viewType) {
            0 -> EpisodesHolder(parent)
            else -> HeaderHolder(parent)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EpisodesHolder -> holder.populate(list[position] as EpisodeModel)
            is HeaderHolder -> holder.populate(list[position] as CharacterInfo)
        }
    }

    override fun getItemCount() = list.size

    fun setData(getLists: List<BaseModel>) {
        list.addAll(getLists)
    }

    fun getData() = list

    override fun getItemViewType(position: Int): Int {
        val data = list[position]
        return when(data) {
            is EpisodeModel -> 0
            else -> 1
        }
    }
}