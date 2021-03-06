package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.models.CharacterInfo
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.domain.RemoteRepository
import com.example.rickandmortyapp.domain.BaseModel
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private val repository: RemoteRepository
) : ViewModel() {

    private var _mainInfoLiveData = MutableLiveData<List<BaseModel>>()
    val mainInfoLiveData: LiveData<List<BaseModel>> get() = _mainInfoLiveData

    fun initByBundle(arguments: Bundle) {
        val dataForScreen = arguments.getParcelable<ListCharacterModel>(GeneralFragment.DATA_KEY)
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