package com.example.rickandmortyapp.feature.characterscreen.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapp.data.models.ListCharacterModel

class CharacterDiffCallback : DiffUtil.ItemCallback<ListCharacterModel>() {

    override fun areItemsTheSame(
        oldItem: ListCharacterModel,
        newItem: ListCharacterModel
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ListCharacterModel,
        newItem: ListCharacterModel
    ) = oldItem == newItem

}