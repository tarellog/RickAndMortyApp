package com.example.rickandmortyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.rickandmortyapp.databinding.FragmentSecondBinding
import com.example.rickandmortyapp.models.ListCharacterModel
import com.squareup.picasso.Picasso
import java.lang.NullPointerException

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Error is not initialized")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        setFragmentResultListener("key") { key, bundle ->
            val qqq = bundle.getParcelable<ListCharacterModel>("key2")
            binding.name.setText(qqq?.name)
            Picasso.get()
            .load(qqq?.image)
            .into(binding.image)
        binding.species.text = qqq?.species
        binding.gender.text = qqq?.gender
        binding.status.text = qqq?.status
        binding.location.text = qqq?.location?.name
//        binding.episode.text = qqq?.episode.toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}