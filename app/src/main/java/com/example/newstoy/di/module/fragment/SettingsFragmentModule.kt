package com.example.newstoy.di.module.fragment

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.newstoy.R
import com.example.newstoy.data.MainRepository
import com.example.newstoy.databinding.FragmentFavoriteBinding
import com.example.newstoy.databinding.FragmentSettingsBinding
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.SearchFragment
import com.example.newstoy.view.fragments.SettingsFragment
import com.example.newstoy.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class SettingsFragmentModule {

    @Provides
    @FragmentScope
    fun provideFragmentSettingsBinding(activity: MainActivity): FragmentSettingsBinding =
        DataBindingUtil.inflate(
            activity.layoutInflater,
            R.layout.fragment_settings,
            null,
            false
        )

    @Provides
    @FragmentScope
    fun provideMainViewModel(fragment: SettingsFragment, repository: MainRepository): MainViewModel =
        ViewModelProviders.of(fragment, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }).get(MainViewModel::class.java)
}