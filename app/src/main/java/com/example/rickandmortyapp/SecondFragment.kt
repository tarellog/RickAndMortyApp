package com.example.rickandmortyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.rickandmortyapp.GeneralFragment.Companion.DATA_KEY
import com.example.rickandmortyapp.databinding.FragmentSecondBinding
import com.example.rickandmortyapp.models.ListCharacterModel
import com.squareup.picasso.Picasso
import java.lang.NullPointerException

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Error is not initialized")

    companion object {
        fun newInstance(dataSecondFragment: ListCharacterModel): SecondFragment{
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

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val dataForScreen = arguments?.getParcelable<ListCharacterModel>(DATA_KEY)
        binding.name.text = dataForScreen?.name
        Picasso.get()
            .load(dataForScreen?.image)
            .into(binding.image)
        binding.species.text = dataForScreen?.species
        binding.gender.text = dataForScreen?.gender
        binding.status.text = dataForScreen?.status
        binding.location.text = dataForScreen?.location?.name
        binding.episode.text = dataForScreen?.getEpisodeList().toString()
        binding.customToolbar.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.customToolbar.textTitle.text = getString(R.string.description)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}