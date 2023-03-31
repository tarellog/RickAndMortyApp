package com.example.rickandmortyapp.feature.characterscreen.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ItemCharacterBinding
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.MaskTransformation

class CharacterHolder(
    private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: ListCharacterModel, callback: (ListCharacterModel) -> Unit) {
        val corner = MaskTransformation(binding.root.context, R.drawable.round_corner_image)
        binding.name.text = item.name
        binding.species.text = item.species
        binding.gender.text = item.gender
        Picasso.get()
            .load(item.image)
            .transform(corner)
            .into(binding.img)

        binding.root.setOnClickListener {
            callback(item)
        }

    }

}