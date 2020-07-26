package com.example.newstoy.di.module.fragment

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.newstoy.R
import com.example.newstoy.data.BasicApi
import com.example.newstoy.data.MainRepository
import com.example.newstoy.databinding.FragmentFavoriteBinding
import com.example.newstoy.databinding.FragmentNewsFeedBinding
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.di.module.ViewModelKey
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.FavoriteFragment
import com.example.newstoy.view.fragments.NewsFeedFragment
import com.example.newstoy.viewmodel.MainViewModel
import com.example.newstoy.viewmodel.MainViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

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
}