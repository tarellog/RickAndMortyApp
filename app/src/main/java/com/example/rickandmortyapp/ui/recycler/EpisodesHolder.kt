package com.example.rickandmortyapp.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.models.EpisodeModel
import com.example.rickandmortyapp.databinding.FragmentSecondBinding
import com.example.rickandmortyapp.databinding.ItemEpisodesBinding

class EpisodesHolder(
    private val binding: ItemEpisodesBinding
    ): RecyclerView.ViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
            ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    fun populate(item: EpisodeModel) {

    }

}