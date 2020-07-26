package com.example.newstoy.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newstoy.data.local.NewsData
import io.reactivex.disposables.Disposable


/**
 *  메 페이지와 상호작용하는 ViewModel class
 */
class MainViewModel : ViewModel() {

//    val newsData: LiveData<List<NewsData>> = getSavedFavorite().switchMap {
//        repository.getNewsList()
//    }

//    val newsData: LiveData<List<NewsData>> = repository.getNewsList()

    private val _refreshStatus = MutableLiveData<Boolean>()
    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    // 아이템을 고를 경우 해당 아이템의 id와 view를 넘
    private val _detailViewData = MutableLiveData<Pair<NewsData, List<Pair<View, String>>>>()
    val detailViewData: LiveData<Pair<NewsData, List<Pair<View, String>>>>
        get() = _detailViewData

    private lateinit var disposable: Disposable

    init {
        observeFinish()
    }

    fun testSearch() {
//        repository.doTestSearch()
    }

    // 상세 뉴스 페이지를 index를 전달해 보여주도록 함.
    fun showNewsDetail(data: NewsData, viewList: List<Pair<View, String>>) {
        _detailViewData.postValue(Pair(data, viewList))
    }

    private fun observeFinish() {
//        disposable = repository.getQueryFininsh()
//            .subscribe {
//                _refreshStatus.postValue(it)
//            }
    }

//    private fun getSavedFavorite(): MutableLiveData<Int> {
//        return savedStateHandle.getLiveData(FAVORITE_SAVED_STATE_KEY, NO_FAVORITE)
//    }

    companion object {
        private const val NO_FAVORITE = -1
        private const val FAVORITE_SAVED_STATE_KEY = "FAVORITE_SAVED_STATE_KEY"
    }
}