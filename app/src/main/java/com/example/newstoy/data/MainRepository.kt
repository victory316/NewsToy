package com.example.newstoy.data

import com.example.newstoy.di.component.ApiComponent
import com.example.newstoy.di.component.DaggerApiComponent
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 *  메인 화면에서의 상호작용에 사용되는 repository
 */
class MainRepository private constructor(private val dao: MainDao) {

    private lateinit var disposable: Disposable

    fun doTestSearch() {
        disposable = BasicClient().getApi().testQuery("kr", DaggerApiComponent.create().getApiKey())
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    Timber.tag("queryTest").d("result : ${it}")
                }, {
                    Timber.tag("queryTest").d("error! : $it")
                }
            )
    }

    companion object {

        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(dao: MainDao) =
            instance ?: synchronized(this) {
                instance ?: MainRepository(dao).also { instance = it }
            }
    }
}
