package com.example.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortyapp.repository.RemoteRepository
import com.example.rickandmortyapp.repository.RemoteRepositoryImpl
import com.example.rickandmortyapp.repository.RickMortyService

class MainActivity : AppCompatActivity() {

    val repository : RemoteRepository = RemoteRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        repository.request()
    }
}