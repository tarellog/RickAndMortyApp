package com.example.rickandmortyapp.repository

interface RemoteRepository {
    fun request()
    fun request(page: Int)
}