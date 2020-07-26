package com.example.newstoy.di.module

import com.example.newstoy.data.MainRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: MainRepository): MainRepository
}