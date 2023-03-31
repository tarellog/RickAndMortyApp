package com.example.rickandmortyapp.feature.episodescreen.ui.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapp.domain.BaseModel

class EpisodeDiffCallback: DiffUtil.ItemCallback<BaseModel>() {

    override fun areItemsTheSame(
        oldItem: BaseModel,
        newItem: BaseModel
    ) = oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: BaseModel,
        newItem: BaseModel
    ) = oldItem == newItem
}