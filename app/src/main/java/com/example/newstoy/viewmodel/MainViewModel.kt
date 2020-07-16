package com.example.newstoy.viewmodel

import androidx.lifecycle.*
import com.example.newstoy.data.MainRepository


/**
 *  메 페이지와 상호작용하는 ViewModel class
 */
class MainViewModel internal constructor(
    private val repository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}