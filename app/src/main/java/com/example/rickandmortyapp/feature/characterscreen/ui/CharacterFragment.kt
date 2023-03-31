package com.example.rickandmortyapp.feature.characterscreen.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.core.ui.viewmodel.ViewModelFactory
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.application.App
import com.example.rickandmortyapp.databinding.FragmentCharacterBinding
import com.example.rickandmortyapp.feature.episodescreen.ui.EpisodeFragment
import com.example.rickandmortyapp.feature.characterscreen.ui.recycler.CharacterAdapter
import com.example.rickandmortyapp.feature.characterscreen.ui.recycler.PageLoaderScrollListener
import java.lang.NullPointerException
import javax.inject.Inject

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CharacterViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var adapter: CharacterAdapter

    private lateinit var paginScrollListener: PageLoaderScrollListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)

        adapter = CharacterAdapter(this::openSecondScreen)
        binding.recycler.adapter = adapter

        //toolbar
        binding.customToolbar.backButton.visibility = View.GONE
        binding.customToolbar.textTitle.text = getString(R.string.character)

        //pagination
        paginScrollListener = PageLoaderScrollListener(
            binding.recycler.layoutManager as LinearLayoutManager,
            viewModel::loadData
        )
        binding.recycler.addOnScrollListener(paginScrollListener)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listCharacterModel.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    fun openSecondScreen(model: ListCharacterModel) {
        findNavController().navigate(R.id.action_generalFragment_to_secondFragment,
            EpisodeFragment.dataForScreen(model)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val DATA_KEY = "key"
    }

}