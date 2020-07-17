package com.example.newstoy.viewmodel

import androidx.lifecycle.*
import com.example.newstoy.data.BasicClient
import com.example.newstoy.data.MainRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/**
 *  메 페이지와 상호작용하는 ViewModel class
 */
class MainViewModel internal constructor(
    private val repository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun testSearch() {
        repository.doTestSearch()
    }
}