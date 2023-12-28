package com.example.rickandmortyapp.feature.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.domain.usecase.DataCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val dataCharacterUseCase: DataCharacterUseCase
) : ViewModel() {

    private val _character = MutableStateFlow<List<ListCharacter>>(emptyList())
    val character: StateFlow<List<ListCharacter>> = _character.asStateFlow()

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch {
            try {
                val listCharacter = dataCharacterUseCase.getCharacter(1).take(6)
                _character.tryEmit(listCharacter)
            } catch (e: Exception) {
                Log.e("error", "error", e)
            }
        }
    }

}