package com.example.newstoy.di.module.fragment

import androidx.databinding.DataBindingUtil
import com.example.newstoy.R
import com.example.newstoy.databinding.FragmentFavoriteBinding
import com.example.newstoy.databinding.FragmentNewsFeedBinding
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.FavoriteFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

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