package com.example.newstoy.di

import dagger.Module
import dagger.Provides

@Module
class MyModule {

    @Provides
    fun proviedHelloWorld(): String {
        return "Hello World"
    }
}