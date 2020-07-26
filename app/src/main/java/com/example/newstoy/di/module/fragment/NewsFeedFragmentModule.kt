package com.example.newstoy.di.module.fragment

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.newstoy.R
import com.example.newstoy.data.MainRepository
import com.example.newstoy.databinding.FragmentNewsFeedBinding
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.NewsFeedFragment
import com.example.newstoy.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class NewsFeedFragmentModule {

    @Provides
    @FragmentScope
    fun provideFragmentFavoriteBinding(activity: MainActivity): FragmentNewsFeedBinding =
        DataBindingUtil.inflate(
            activity.layoutInflater,
            R.layout.fragment_news_feed,
            null,
            false
        )


    @Provides
    @FragmentScope
    fun provideMainViewModel(fragment: NewsFeedFragment, repository: MainRepository): MainViewModel =
        ViewModelProviders.of(fragment, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }).get(MainViewModel::class.java)
}