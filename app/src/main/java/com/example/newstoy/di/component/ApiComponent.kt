package com.example.newstoy.di.component

import com.example.newstoy.di.module.ApiModule
import com.example.newstoy.di.module.MyModule
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun getApiKey(): String
}