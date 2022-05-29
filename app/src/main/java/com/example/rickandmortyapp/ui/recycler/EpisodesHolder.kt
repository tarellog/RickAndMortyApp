package com.example.rickandmortyapp.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.databinding.ItemEpisodesBinding

class EpisodesHolder(
    private val binding: ItemEpisodesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: EpisodeModel) {
        binding.id.text = binding.root.context.getString(R.string.episod, item.id)
        binding.nameEpisode.text = item.name
        binding.date.text = item.air_date
    }

}