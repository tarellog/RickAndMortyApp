package com.example.rickandmortyapp.feature.characterscreen.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.domain.models.ListCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    private var _listCharacterModel = MutableStateFlow<List<ListCharacter>>(emptyList())
    val listCharacterModel = _listCharacterModel.asStateFlow()

    init {
        loadData()
    }

    fun loadData(page: Int = 1) {
        repository.request(page)
            .doOnNext {
                Log.d("MyTag", it.toString())
                val resultList = it.toMutableList().apply {
                    _listCharacterModel.value?.let { it1 -> addAll(0, it1) }
                }.toList()
                _listCharacterModel.tryEmit(resultList)
                Log.d("MyTag", resultList.toString())
            }
            .doOnError { it.message }
            .subscribe()
    }

}