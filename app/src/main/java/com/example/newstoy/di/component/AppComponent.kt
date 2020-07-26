package com.example.newstoy.di.component

import android.content.Context
import com.example.newstoy.App
import com.example.newstoy.data.MainRepository
import com.example.newstoy.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.Module
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
        ViewModelBuilderModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

    fun mainComponent(): MainComponent.Factory
}


@Module(
    subcomponents = [
        MainComponent::class
    ]
)
object SubcomponentsModule