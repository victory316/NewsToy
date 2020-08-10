package com.example.newstoy.viewmodel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.*
import com.example.newstoy.data.BasicApi
import com.example.newstoy.data.MainRepository
import com.example.newstoy.data.local.NewsData
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


/**
 *  메 페이지와 상호작용하는 ViewModel class
 */
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private lateinit var disposable: Disposable

    val newsData: LiveData<List<NewsData>> = repository.getNewsList()

    private val _refreshStatus = MutableLiveData<Boolean>()
    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    // 아이템을 고를 경우 해당 아이템의 id와 view를 넘김
    private val _detailViewData = MutableLiveData<Pair<NewsData, List<Pair<View, String>>>>()
    val detailViewData: LiveData<Pair<NewsData, List<Pair<View, String>>>>
        get() = _detailViewData

    private val _showInfoData = MutableLiveData<Boolean>()
    val showInfoData: LiveData<Boolean>
        get() = _showInfoData

    private val _resetData = MutableLiveData<Boolean>()
    val resetData: LiveData<Boolean>
        get() = _resetData

    init {
        observeFinish()
    }

    fun testSearch() {
        repository.doTestSearch()
    }

    // 상세 뉴스 페이지를 index를 전달해 보여주도록 함.
    fun showNewsDetail(data: NewsData, viewList: List<Pair<View, String>>) {
        _detailViewData.postValue(Pair(data, viewList))
    }

    private fun observeFinish() {
        disposable = repository.getQueryFininsh()
            .subscribe {
                _refreshStatus.postValue(it)
            }
    }

    fun showInformationPage() {
        _showInfoData.postValue(true)
    }

    fun showResetDialog() {
        _resetData.postValue(true)
    }
}