package com.example.rickandmortyapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.models.ListCharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterHolder>() {

    private val list: MutableList<ListCharacterModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterHolder(parent)

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount() = list.size

    fun setData(getLists: List<ListCharacterModel>) {
        list.addAll(getLists)
        notifyDataSetChanged()
    }

}