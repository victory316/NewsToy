package com.example.newstoy.di.component

import com.example.newstoy.di.module.MainViewModelModule
import com.example.newstoy.di.module.MyModule
import com.example.newstoy.viewmodel.MainViewModel
import dagger.Component

interface ViewModelComponent {
    fun getViewModel(): MainViewModel
}