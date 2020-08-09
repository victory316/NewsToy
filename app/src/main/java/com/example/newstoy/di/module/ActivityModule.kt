package com.example.newstoy.di.module

import com.example.newstoy.di.ActivityScope
import com.example.newstoy.di.module.activity.DetailActivityModule
import com.example.newstoy.di.module.activity.MainActivityModule
import com.example.newstoy.view.DetailActivity
import com.example.newstoy.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun getMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DetailActivityModule::class)])
    abstract fun getDetailActivity(): DetailActivity
}