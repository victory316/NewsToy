package com.example.newstoy.di.component

import com.example.newstoy.App
import com.example.newstoy.data.MainRepository
import com.example.newstoy.di.module.ActivityModule
import com.example.newstoy.di.module.AppModule
import com.example.newstoy.di.module.AppModuleBinds
import com.example.newstoy.di.module.ViewModelBuilderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
        AppModuleBinds::class,
        ViewModelBuilderModule::class]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}