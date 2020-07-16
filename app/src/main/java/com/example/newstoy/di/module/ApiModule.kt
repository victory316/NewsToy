package com.example.newstoy.di.module

import dagger.Module
import dagger.Provides

/**
 *  Api Key를 제공하는 Module
 */
@Module
class ApiModule {

    @Provides
    fun provideApiKey(): String {
        return API_KEY
    }

    companion object {
        const val API_KEY = "198e76f861e24d5cac3780e47b72115d"
    }
}