package com.example.newstoy.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.newstoy.data.MainDatabase
import com.example.newstoy.data.MainRepository
import com.example.newstoy.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

class MainViewModelModule {
//    private fun getMainRepository(context: Context): MainRepository {
//        return MainRepository.getInstance(
//            MainDatabase.getInstance(context.applicationContext)!!.getMainDao()
//        )
//    }
//
//    @Provides
//    fun provideMainVieWModule(fragment: Fragment): MainViewModelFactory {
//        val repository = getMainRepository(fragment.requireContext())
//        return MainViewModelFactory(repository, fragment)
//    }
}