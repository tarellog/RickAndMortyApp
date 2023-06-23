package com.example.rickandmortyapp.feature.episodescreen.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.application.App
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.feature.characterscreen.ui.CharacterFragment.Companion.DATA_KEY
import com.example.rickandmortyapp.databinding.FragmentEpisodeBinding
import com.example.rickandmortyapp.domain.models.ListCharacter
import com.example.rickandmortyapp.feature.episodescreen.ui.recycler.EpisodesAdapter
import java.lang.NullPointerException
import javax.inject.Inject

class EpisodeFragment : Fragment() {

    private var _binding: FragmentEpisodeBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Error is not initialized")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EpisodeViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var adapter: EpisodesAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodeBinding.inflate(inflater, container, false)

        adapter = EpisodesAdapter()
        binding.episodeRecycler.adapter = adapter

        //toolbar
        binding.customToolbar.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.customToolbar.textTitle.text = getString(R.string.description)

        arguments?.let {
            viewModel.initByBundle(it)
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.mainInfoLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun dataForScreen(model: ListCharacter) = bundleOf(DATA_KEY to model)
    }

}