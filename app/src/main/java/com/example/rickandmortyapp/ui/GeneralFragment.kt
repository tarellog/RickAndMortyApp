package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentGeneralBinding
import com.example.rickandmortyapp.data.models.ListCharacterModel
import com.example.rickandmortyapp.ui.recycler.CharacterAdapter
import com.example.rickandmortyapp.ui.recycler.DIffUtils
import com.example.rickandmortyapp.ui.recycler.PageLoaderScrollListener
import java.lang.NullPointerException

class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    private lateinit var viewModel: GeneralViewModel

    private lateinit var adapter: CharacterAdapter

    private lateinit var paginScrollListener: PageLoaderScrollListener

    private fun callbackData(callback: ListCharacterModel) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, SecondFragment.newInstance(callback))
            .addToBackStack(this.javaClass.simpleName)
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(GeneralViewModel::class.java)

        adapter = CharacterAdapter(this::callbackData)

        binding.customToolbar.backButton.visibility = View.GONE
        binding.customToolbar.textTitle.text = getString(R.string.character)

        paginScrollListener = PageLoaderScrollListener(
            binding.recycler.layoutManager as LinearLayoutManager,
            viewModel::loadData
        )
        binding.recycler.addOnScrollListener(paginScrollListener)
        binding.recycler.adapter = adapter

        viewModel.listCharacterModel.observe(viewLifecycleOwner) {
                val productDiffUtilCallback = DIffUtils(adapter.getData(), it)
                val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)

                adapter.setData(it)
                productDiffResult.dispatchUpdatesTo(adapter)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val DATA_KEY = "key"
    }

}