package com.example.rickandmortyapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterViewModel
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeViewModel
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelKey
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun provideViewModel(viewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EpisodeViewModel::class)
    abstract fun provideViewModelSecond(viewModel: EpisodeViewModel): ViewModel

}