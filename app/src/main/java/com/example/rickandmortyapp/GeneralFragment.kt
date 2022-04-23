package com.example.rickandmortyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentGeneralBinding
import com.example.rickandmortyapp.models.CharacterModel
import com.example.rickandmortyapp.models.ListCharacterModel
import com.example.rickandmortyapp.recycler.CharacterAdapter
import com.example.rickandmortyapp.recycler.DiffUtils
import com.example.rickandmortyapp.recycler.PageLoaderScrollListener
import com.example.rickandmortyapp.repository.RemoteRepository
import com.example.rickandmortyapp.repository.RemoteRepositoryImpl
import java.lang.NullPointerException

class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    private val repository: RemoteRepository = RemoteRepositoryImpl(this::repositoryCallback)

    private val adapter: CharacterAdapter = CharacterAdapter(this::callbackData)

    private lateinit var paginScrollListener: PageLoaderScrollListener

    fun repositoryCallback(model: CharacterModel) {
        val resultCharacterList = model.results.toMutableList().apply {
            addAll(0, adapter.getData())
        }.toList()
        val productDiffUtilCallback = DiffUtils(adapter.getData(), resultCharacterList)
        val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)

        adapter.setData(resultCharacterList)
        productDiffResult.dispatchUpdatesTo(adapter)
    }

    fun callbackData(callback: ListCharacterModel) {

        val secondFragment = SecondFragment()
        secondFragment.apply {
            arguments = bundleOf("key" to callback)
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, secondFragment)
            .addToBackStack(this.javaClass.simpleName)
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralBinding.inflate(inflater, container, false)
        repository.request()
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        paginScrollListener = PageLoaderScrollListener(
            binding.recycler.layoutManager as LinearLayoutManager,
            repository::request
        )

        binding.recycler.addOnScrollListener(paginScrollListener)
        binding.recycler.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}