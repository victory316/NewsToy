package com.example.newstoy.di.module

import com.example.newstoy.di.ActivityScope
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.view.MainActivity
import com.example.newstoy.view.fragments.FavoriteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun getMainActivity(): MainActivity

//    @FragmentScope
//    @ContributesAndroidInjector(modules = [(FavoriteFragmentModule::class)])
//    abstract fun getFavoriteFragment(): FavoriteFragment
}