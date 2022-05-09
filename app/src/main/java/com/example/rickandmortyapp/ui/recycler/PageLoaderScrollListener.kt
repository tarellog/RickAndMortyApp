package com.example.rickandmortyapp.ui.recycler

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PageLoaderScrollListener(
    private val linearLayoutManager: LinearLayoutManager,
    private val loadMoreData: (nextPage: Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var currentPage = 1

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItemCount = linearLayoutManager.itemCount
        val firstVisibilityItemPosition = linearLayoutManager.findFirstVisibleItemPosition()

        if (firstVisibilityItemPosition + 8 >= totalItemCount && firstVisibilityItemPosition >= 0) {
            loadMoreData(++currentPage)
        }
    }
}