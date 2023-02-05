package com.example.rickandmortyapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.databinding.FragmentGeneralBinding
import com.example.rickandmortyapp.ui.recycler.CharacterAdapter
import com.example.rickandmortyapp.ui.recycler.DIffUtils
import com.example.rickandmortyapp.ui.recycler.PageLoaderScrollListener
import java.lang.NullPointerException


class GeneralFragment : Fragment(){

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    private val viewModel: CharacterViewModel by viewModels {
        getApp().appComponent.viewModelFactory()
    }

    private lateinit var adapter: CharacterAdapter

    private lateinit var paginScrollListener: PageLoaderScrollListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        getApp().appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralBinding.inflate(inflater, container, false)

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
            val productDiffUtilCallback = DIffUtils(adapter.getData(), it)
            val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)

            adapter.setData(it)
            productDiffResult.dispatchUpdatesTo(adapter)
        }
    }

    fun openSecondScreen(model: ListCharacterModel) {
        findNavController().navigate(R.id.action_generalFragment_to_secondFragment, SecondFragment.dataForScreen(model))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        var instance: App = App()

        fun getApp() : App {
            return instance
        }

        const val DATA_KEY = "key"
    }

}