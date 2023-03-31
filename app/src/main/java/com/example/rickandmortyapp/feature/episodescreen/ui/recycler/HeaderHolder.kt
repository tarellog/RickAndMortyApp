package com.example.rickandmortyapp.feature.episodescreen.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.databinding.ItemHeaderBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.MaskTransformation

class HeaderHolder(
    private val binding: ItemHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    fun populate(item: CharacterInfo) {
        val corner = MaskTransformation(binding.root.context, R.drawable.round_corner_image)
        Picasso.get()
            .load(item.image)
            .transform(corner)
            .into(binding.image)

        binding.name.text = item.name
        binding.species.text = item.species
        binding.gender.text = item.gender
        binding.status.text = item.status
        binding.location.text = item.location
    }
}