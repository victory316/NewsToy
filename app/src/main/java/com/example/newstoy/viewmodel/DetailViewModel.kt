package com.example.newstoy.viewmodel

import androidx.lifecycle.*
import com.example.newstoy.data.MainRepository
import com.example.newstoy.data.local.NewsData
import javax.inject.Inject

/**
 *  상세 화면을 보여주기 위한 ViewModel
 */
class DetailViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    var detailData: LiveData<NewsData>? = null

    fun loadNewsWithId(id: Int) {
        detailData = repository.getNewsWithId(id)
    }
}