package com.example.newstoy.di.module.activity

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.newstoy.R
import com.example.newstoy.data.MainRepository
import com.example.newstoy.databinding.ActivityDetailBinding
import com.example.newstoy.databinding.ActivityMainBinding
import com.example.newstoy.di.ActivityScope
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.di.module.fragment.FavoriteFragmentModule
import com.example.newstoy.di.module.fragment.NewsFeedFragmentModule
import com.example.newstoy.di.module.fragment.SearchFragmentModule
import com.example.newstoy.di.module.fragment.SettingsFragmentModule
import com.example.newstoy.view.DetailActivity
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.FavoriteFragment
import com.example.newstoy.view.fragments.NewsFeedFragment
import com.example.newstoy.view.fragments.SearchFragment
import com.example.newstoy.view.fragments.SettingsFragment
import com.example.newstoy.viewmodel.DetailViewModel
import com.example.newstoy.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailActivityModule {
    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideDetailActivityBinding(activity: DetailActivity): ActivityDetailBinding {
            return DataBindingUtil.setContentView(activity, R.layout.activity_detail)
        }
    }

//    @Provides
    @ActivityScope
    fun provideDetailViewModel(
        activity: DetailActivity,
        repository: MainRepository
    ): DetailViewModel =
        ViewModelProviders.of(activity, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DetailViewModel(repository) as T
            }
        }).get(DetailViewModel::class.java)
}