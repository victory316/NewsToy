package com.example.newstoy.util

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.newstoy.data.MainDatabase
import com.example.newstoy.data.MainRepository
import com.example.newstoy.viewmodel.MainViewModelFactory

/**
 *
 *  InjectorUtils
 *
 *  - Database와 viewModel의 Injection을 돕는 class
 *
 */

object InjectorUtils {
    private fun getMainRepository(context: Context): MainRepository {
        return MainRepository.getInstance(
            MainDatabase.getInstance(context.applicationContext)!!.getMainDao()
        )
    }

    fun provideMainViewModel(fragment: Fragment): MainViewModelFactory {
        val repository = getMainRepository(fragment.requireContext())
        return MainViewModelFactory(repository, fragment)
    }
}