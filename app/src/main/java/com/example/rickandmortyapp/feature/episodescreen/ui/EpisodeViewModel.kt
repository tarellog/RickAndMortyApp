package com.example.rickandmortyapp.feature.episodescreen.ui

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.data.RemoteRepository
import com.example.rickandmortyapp.domain.BaseModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    private var _mainInfoLiveData = MutableLiveData<List<BaseModel>>()
    val mainInfoLiveData: LiveData<List<BaseModel>> get() = _mainInfoLiveData

    fun initByBundle(arguments: Bundle) {
        val dataForScreen = arguments.getParcelable<ListCharacter>(CharacterFragment.DATA_KEY)
        dataForScreen?.let { data ->
            repository.getEpisodes(data.getEpisodeList())
                .subscribe({
                    val resultList: MutableList<BaseModel> = it.toMutableList()
                    resultList.add(
                        0, CharacterInfo(
                            data.name,
                            data.image,
                            data.species,
                            data.gender,
                            data.status,
                            data.location.name
                        )
                    )
                    _mainInfoLiveData.postValue(resultList)
                }) {}
        }
    }

}