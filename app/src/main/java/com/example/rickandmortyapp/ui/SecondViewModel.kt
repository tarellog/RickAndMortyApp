package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.data.RemoteRepositoryImpl

class SecondViewModel : ViewModel() {

    val repository: RemoteRepository = RemoteRepositoryImpl()

    private var _mainInfoLiveData = MutableLiveData<CharacterInfo>()
    val mainInfoLiveData: LiveData<CharacterInfo> get() = _mainInfoLiveData

    fun initByBundle(arguments: Bundle) {
        val dataForScreen = arguments.getParcelable<ListCharacterModel>(GeneralFragment.DATA_KEY)
        dataForScreen?.let { data ->
            repository.getEpisodes(data.getEpisodeList())
                .map {
                    CharacterInfo(
                        data.name,
                        data.image,
                        data.species,
                        data.gender,
                        data.status,
                        data.location.name,
                        it.map { it.name }
                    )
                }
                .subscribe({
                    _mainInfoLiveData.postValue(it)
                }) {}
        }
    }

}