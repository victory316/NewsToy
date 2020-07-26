package com.example.newstoy

import android.app.Application
import android.content.Context
import com.example.newstoy.di.component.AppComponent
import com.example.newstoy.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    // Instance of the AppComponent that will be used by all the Activities in the project
//    val appComponent: AppComponent by lazy {
//        initializeComponent()
//    }
//
//    open fun initializeComponent(): AppComponent {
//        // Creates an instance of AppComponent using its Factory constructor
//        // We pass the applicationContext that will be used as Context in the graph
//        return DaggerAppComponent.factory().create(applicationContext)
//    }


    override fun onCreate() {

        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
//        MultiDex.install(this)
    }
}