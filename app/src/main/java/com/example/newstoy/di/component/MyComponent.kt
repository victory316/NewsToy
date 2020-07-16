package com.example.newstoy.di.component

import com.example.newstoy.di.module.MyModule
import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {
    fun getString(): String
}