package com.example.rickandmortyapp.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.models.ListCharacterModel

class CharacterAdapter(
    private val callback: (ListCharacterModel) -> Unit
) : RecyclerView.Adapter<CharacterHolder>() {

    private val list: MutableList<ListCharacterModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterHolder(parent)

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.populate(list[position], callback)
    }

    override fun getItemCount() = list.size

    fun setData(getLists: List<ListCharacterModel>) {
        list.clear()
        list.addAll(getLists)
    }

    fun getData() = list
}