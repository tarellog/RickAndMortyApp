package com.example.rickandmortyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.databinding.ItemCharacterBinding
import com.example.rickandmortyapp.models.ListCharacterModel
import com.squareup.picasso.Picasso

class CharacterHolder(
    private val binding: ItemCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: ListCharacterModel, callback: (ListCharacterModel) -> Unit) {
        binding.name.text = item.name
        binding.species.text = item.species
        binding.gender.text = item.gender
        Picasso.get()
            .load(item.image)
            .into(binding.img)

        binding.root.setOnClickListener {
            callback(item)
        }
    }

}