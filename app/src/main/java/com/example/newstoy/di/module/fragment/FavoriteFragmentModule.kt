package com.example.newstoy.di.module.fragment

import androidx.databinding.DataBindingUtil
import com.example.newstoy.R
import com.example.newstoy.databinding.FragmentFavoriteBinding
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.view.MainActivity
import dagger.Module
import dagger.Provides

@Module
class FavoriteFragmentModule {

    @Provides
    @FragmentScope
    fun provideFragmentMainBinding(activity: MainActivity): FragmentFavoriteBinding =
        DataBindingUtil.inflate(
            activity.layoutInflater,
            R.layout.fragment_favorite,
            null,
            false
        )
}