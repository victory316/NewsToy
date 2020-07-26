package com.example.newstoy.di.component

import com.example.newstoy.di.module.MainViewModelModule
import com.example.newstoy.view.fragments.NewsFeedFragment
import dagger.Subcomponent


@Subcomponent(modules = [MainViewModelModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

//    fun inject(fragment: NewsFeedFragment)
}