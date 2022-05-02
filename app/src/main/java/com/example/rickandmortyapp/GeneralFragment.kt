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
import com.example.rickandmortyapp.models.ListCharacterModel
import com.example.rickandmortyapp.recycler.CharacterAdapter
import com.example.rickandmortyapp.recycler.DIffUtils
import com.example.rickandmortyapp.recycler.PageLoaderScrollListener
import com.example.rickandmortyapp.repository.RemoteRepository
import com.example.rickandmortyapp.repository.RemoteRepositoryImpl
import java.lang.NullPointerException

class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    private val repository: RemoteRepository = RemoteRepositoryImpl()

    private val adapter: CharacterAdapter = CharacterAdapter(this::callbackData)

    private lateinit var paginScrollListener: PageLoaderScrollListener

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
        loadData()

        binding.customToolbar.backButton.visibility = View.GONE
        binding.customToolbar.textTitle.text = getString(R.string.character)

        paginScrollListener = PageLoaderScrollListener(
            binding.recycler.layoutManager as LinearLayoutManager,
            this::loadData
        )

        binding.recycler.addOnScrollListener(paginScrollListener)
        binding.recycler.adapter = adapter
        return binding.root
    }

    private fun loadData(page: Int = 1) {
        repository.request(page)
            .map {
                it.toMutableList().apply {
                    addAll(0, adapter.getData())
                }.toList()
            }
            .subscribe({
                val productDiffUtilCallback = DIffUtils(adapter.getData(), it)
                val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)

                adapter.setData(it)
                productDiffResult.dispatchUpdatesTo(adapter)
            }) {}
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}