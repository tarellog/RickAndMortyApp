package com.example.rickandmortyapp.feature.episodescreen.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.application.App
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment.Companion.DATA_KEY
import com.example.rickandmortyapp.domain.models.ListCharacter
import javax.inject.Inject

class EpisodeFragment : Fragment() {

    private lateinit var composeView: ComposeView

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EpisodeViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            viewModel.initByBundle(it)
        }
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        composeView.setContent {
            val viewModelFactory: () -> ViewModelProvider.Factory = remember { { viewModelFactory } }
            EpisodeScreen(
                viewModelFactory = viewModelFactory
            )
        }
    }

    companion object {
        fun dataForScreen(model: ListCharacter) = bundleOf(DATA_KEY to model)
    }

}