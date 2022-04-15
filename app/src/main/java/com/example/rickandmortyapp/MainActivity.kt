package com.example.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.models.CharacterModel
import com.example.rickandmortyapp.repository.RemoteRepository
import com.example.rickandmortyapp.repository.RemoteRepositoryImpl
import com.example.rickandmortyapp.repository.RickMortyService
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        supportFragmentManager.beginTransaction()
            .add(binding.containerFragment.id, GeneralFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}