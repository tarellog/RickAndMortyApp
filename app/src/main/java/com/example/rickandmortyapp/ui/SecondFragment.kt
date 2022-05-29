package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.ui.GeneralFragment.Companion.DATA_KEY
import com.example.rickandmortyapp.databinding.FragmentSecondBinding
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.ui.recycler.EpisodesAdapter
import com.squareup.picasso.Picasso
import java.lang.NullPointerException

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Error is not initialized")

    private val viewModel: SecondViewModel by viewModels {
        GeneralFragment.getApp().appComponent.viewModelFactory()
    }

    private lateinit var adapter: EpisodesAdapter

    companion object {
        fun newInstance(dataSecondFragment: ListCharacterModel): SecondFragment {
            return SecondFragment().apply {
                arguments = bundleOf(DATA_KEY to dataSecondFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        adapter = EpisodesAdapter()
        binding.episodeRecycler.adapter = adapter

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

        //toolbar
        binding.customToolbar.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.customToolbar.textTitle.text = getString(R.string.description)
    }

    fun loadData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}