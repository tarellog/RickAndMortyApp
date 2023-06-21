package com.example.rickandmortyapp.feature.characterscreen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.domain.RemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    private var _listCharacterModel = MutableStateFlow<List<ListCharacterModel>>(emptyList())
    val listCharacterModel = _listCharacterModel.asStateFlow()

    init {
        loadData()
    }

    fun loadData(page: Int = 1) {
        repository.request(page)
            .doOnNext {
                val resultList = it.toMutableList().apply {
                    _listCharacterModel.value?.let { it1 -> addAll(0, it1) }
                }.toList()
                _listCharacterModel.tryEmit(resultList)
            }
            .doOnError { it.message }
            .subscribe()
    }

}