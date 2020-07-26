package com.example.newstoy.di.module.activity

import androidx.databinding.DataBindingUtil
import com.example.newstoy.R
import com.example.newstoy.databinding.ActivityMainBinding
import com.example.newstoy.di.ActivityScope
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.di.module.fragment.FavoriteFragmentModule
import com.example.newstoy.di.module.fragment.NewsFeedFragmentModule
import com.example.newstoy.di.module.fragment.SearchFragmentModule
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.FavoriteFragment
import com.example.newstoy.view.fragments.NewsFeedFragment
import com.example.newstoy.view.fragments.SearchFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideMainActivityBinding(activity: MainActivity): ActivityMainBinding {
            return DataBindingUtil.setContentView(activity, R.layout.activity_main)
        }

    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FavoriteFragmentModule::class)])
    abstract fun getFavoriteFragment(): FavoriteFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(NewsFeedFragmentModule::class)])
    abstract fun getNewsFeedFragment(): NewsFeedFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(SearchFragmentModule::class)])
    abstract fun getSearchFragment(): SearchFragment
}