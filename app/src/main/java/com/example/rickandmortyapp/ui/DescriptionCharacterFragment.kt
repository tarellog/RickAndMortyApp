package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.ui.CharacterFragment.Companion.DATA_KEY
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.databinding.FragmentDescriptionCharacterBinding
import com.example.rickandmortyapp.ui.recycler.EpisodesAdapter
import java.lang.NullPointerException

class DescriptionCharacterFragment : Fragment() {

    private var _binding: FragmentDescriptionCharacterBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Error is not initialized")

    private val viewModel: DescriptionCharacterViewModel by viewModels {
        CharacterFragment.getApp().appComponent.viewModelFactory()
    }

    private lateinit var adapter: EpisodesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescriptionCharacterBinding.inflate(inflater, container, false)

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
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun dataForScreen(model: ListCharacterModel) = bundleOf(DATA_KEY to model)
    }

}