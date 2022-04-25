package com.example.rickandmortyapp.recycler

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PageLoaderScrollListener(
    private val linearLayoutManager: LinearLayoutManager,
    private val loadMoreData: (nextPage: Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var currentPage = 1

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItemCount = linearLayoutManager.itemCount
        val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()

        if (firstVisibleItemPosition + 8 >= totalItemCount && firstVisibleItemPosition >= 0) {
            loadMoreData(++currentPage)
        }
    }
}