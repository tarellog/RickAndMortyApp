package com.example.rickandmortyapp.feature.episodescreen.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.data.RemoteRepository
import com.example.rickandmortyapp.domain.BaseModel
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    private var _mainInfoLiveData = MutableLiveData<List<BaseModel>>()
    val mainInfoLiveData: LiveData<List<BaseModel>> get() = _mainInfoLiveData

    fun initByBundle(arguments: Bundle) {
        viewModelScope.launch {
            try {
                val dataForScreen = arguments.getParcelable<ListCharacter>(CharacterFragment.DATA_KEY)
                dataForScreen?.let { data ->
                    val listEpisode = repository.getEpisodes(data.getEpisodeList())
                    val resultList: MutableList<BaseModel> = listEpisode.toMutableList()
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
                }
            } catch (e: Throwable) {
                Log.e("MyTag", "Error", e)
            }
        }

    }

}