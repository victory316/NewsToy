package com.example.newstoy.viewmodel

import androidx.lifecycle.*
import com.example.newstoy.data.MainRepository
import com.example.newstoy.data.local.NewsData


/**
 *  메 페이지와 상호작용하는 ViewModel class
 */
class MainViewModel internal constructor(
    private val repository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val newsData: LiveData<List<NewsData>> = getSavedFavorite().switchMap {
        repository.getNewsList()
    }

    fun testSearch() {
        repository.doTestSearch()
    }

    private fun getSavedFavorite(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(FAVORITE_SAVED_STATE_KEY, NO_FAVORITE)
    }

    companion object {
        private const val NO_FAVORITE = -1
        private const val FAVORITE_SAVED_STATE_KEY = "FAVORITE_SAVED_STATE_KEY"
    }
}