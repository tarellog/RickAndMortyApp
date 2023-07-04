package com.example.rickandmortyapp.feature.characterscreen.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.application.App
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeFragment
import javax.inject.Inject

class CharacterFragment : Fragment() {

    private lateinit var composeView: ComposeView

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        composeView.setContent {
            val viewModelFactory: () -> ViewModelProvider.Factory = remember { { viewModelFactory } }
            CharacterScreen(
                viewModelFactory = viewModelFactory,
                onCharacterClicked = (::openSecondScreen),
            )
        }

    }

    private fun openSecondScreen(model: ListCharacter) {
        findNavController().navigate(
            R.id.action_generalFragment_to_secondFragment,
            EpisodeFragment.dataForScreen(model)
        )
    }

    companion object {
        const val DATA_KEY = "key"
    }

}