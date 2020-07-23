package com.example.newstoy.di.module

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import com.example.newstoy.di.ViewModelKey
import com.example.newstoy.viewmodel.MainViewModel
import com.example.newstoy.viewmodel.MainViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindRepoViewModel(mainViewModel: MainViewModel): MainViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory
}