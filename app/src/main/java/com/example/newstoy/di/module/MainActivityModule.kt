package com.example.newstoy.di.module

import androidx.databinding.DataBindingUtil
import com.example.newstoy.R
import com.example.newstoy.databinding.ActivityMainBinding
import com.example.newstoy.di.ActivityScope
import com.example.newstoy.di.FragmentScope
import com.example.newstoy.view.MainActivity
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

//
//    @FragmentScope
//    @ContributesAndroidInjector(modules = [(MainFragmentModule::class)])
//    abstract fun getMainFragment(): MainFragment

}