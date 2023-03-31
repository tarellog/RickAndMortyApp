package com.example.rickandmortyapp.feature.episodescreen.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.domain.BaseModel

class EpisodesAdapter : ListAdapter<BaseModel, RecyclerView.ViewHolder>(EpisodeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when(viewType) {
            0 -> EpisodesHolder(parent)
            else -> HeaderHolder(parent)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EpisodesHolder -> holder.populate(getItem(position) as EpisodeModel)
            is HeaderHolder -> holder.populate(getItem(position) as CharacterInfo)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when(getItem(position)) {
            is EpisodeModel -> 0
            else -> 1
        }

}