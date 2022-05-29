package com.example.rickandmortyapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.data.RemoteRepositoryImpl
import com.example.rickandmortyapp.data.RickMortyService
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class GeneralViewModel @Inject constructor(val repository: RemoteRepository) : ViewModel() {

    private var _listCharacterModel = MutableLiveData<List<ListCharacterModel>>()
    val listCharacterModel: LiveData<List<ListCharacterModel>> get() = _listCharacterModel

    private var _adapterData =
        MutableSharedFlow<ListCharacterModel>(0, 1, BufferOverflow.DROP_OLDEST)
    val adapterData get() = _adapterData.asSharedFlow()

    init {
        loadData()
    }

    fun loadData(page: Int = 1) {
        repository.request(page)
            .subscribe({
                val resultList = it.toMutableList().apply {
                    _listCharacterModel.value?.let { it1 -> addAll(0, it1) }
                }.toList()
                _listCharacterModel.postValue(resultList)
            }) {}
    }

    fun callbackData(callback: ListCharacterModel) {
        _adapterData.tryEmit(callback)
    }

}