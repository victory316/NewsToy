package com.example.newstoy.viewmodel

import androidx.lifecycle.*
import com.example.newstoy.data.MainRepository
import com.example.newstoy.data.local.NewsData
import io.reactivex.disposables.Disposable


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

    private val _refreshStatus = MutableLiveData<Boolean>()
    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    // 아이템을 고를 경우 해당 아이템의 id를 전달하는 LiveData
    private val _detailViewId = MutableLiveData<Int>()
    val detailViewId: LiveData<Int>
        get() = _detailViewId


    private lateinit var disposable: Disposable

    init {
        observeFinish()
    }

    fun testSearch() {
        repository.doTestSearch()
    }

    // 상세 뉴스 페이지를 index를 전달해 보여주도록 함.
    fun showNewsDetail(index: Int) {
        _detailViewId.postValue(index)
    }

    private fun observeFinish() {
        disposable = repository.getQueryFininsh()
            .subscribe {
                _refreshStatus.postValue(it)
            }
    }

    private fun getSavedFavorite(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(FAVORITE_SAVED_STATE_KEY, NO_FAVORITE)
    }

    companion object {
        private const val NO_FAVORITE = -1
        private const val FAVORITE_SAVED_STATE_KEY = "FAVORITE_SAVED_STATE_KEY"
    }
}