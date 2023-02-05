package com.example.rickandmortyapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class FactoryViewModels @Inject constructor(
    viewModelProvider: Provider<CharacterViewModel>,
    secondViewModelProvider: Provider<DescriptionCharacterViewModel>
) : ViewModelProvider.Factory {

    private val provide = mapOf(
        CharacterViewModel::class.java to viewModelProvider,
        DescriptionCharacterViewModel::class.java to secondViewModelProvider
    )

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return provide[modelClass]?.get() as T
    }
}