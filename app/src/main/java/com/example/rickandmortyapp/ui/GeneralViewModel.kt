package com.example.rickandmortyapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.domain.RemoteRepository
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class GeneralViewModel @Inject constructor(
    private val repository: RemoteRepository
    ) : DisposableViewModel() {

    sealed class ViewState {
        data class CharacterModels(
            val items: List<ListCharacterModel>
        ) : ViewState()
    }

    private var _listCharacterModel = MutableLiveData<ViewState>()
    val listCharacterModel: LiveData<ViewState> get() = _listCharacterModel

    private var _adapterData =
        MutableSharedFlow<ListCharacterModel>(0, 1, BufferOverflow.DROP_OLDEST)
    val adapterData get() = _adapterData.asSharedFlow()

    init {
        loadData()
    }

    fun loadData(page: Int = 1) {
        repository.request(page)
            .subscribe({ items ->
                _listCharacterModel.postValue(
                    ViewState.CharacterModels(items)
                )
            }, {
                //тут надо обработать ошибку или кинуть в лог
            })
            .untilDestroyView()

    }

    fun callbackData(callback: ListCharacterModel) {
        _adapterData.tryEmit(callback)
    }

}