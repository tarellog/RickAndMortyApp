package com.example.rickandmortyapp.feature.characterscreen.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rickandmortyapp.data.models.ListCharacterModel

class CharacterAdapter(
    private val callback: (ListCharacterModel) -> Unit
) : ListAdapter<ListCharacterModel, CharacterHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterHolder(parent)

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.populate(getItem(position), callback)
    }

}