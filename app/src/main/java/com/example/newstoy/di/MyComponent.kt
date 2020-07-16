package com.example.newstoy.di

import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {
    fun getString(): String
}