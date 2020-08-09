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
 *  상세 화면을 보여주기 위한 ViewModel
 */
class DetailViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private var detailData: LiveData<NewsData>? = null

    fun loadNewsWithId(id: Int) {
        detailData = repository.getNewsWithId(id)

        Timber.tag("test").d("id : $id | data : ${detailData!!.value}")
    }

}