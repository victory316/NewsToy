package com.example.newstoy.di.module.fragment

import com.example.newstoy.data.MainDao
import com.example.newstoy.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    fun provideMainRepository(dao: MainDao): MainRepository {
        return MainRepository.getInstance(dao)
    }
}