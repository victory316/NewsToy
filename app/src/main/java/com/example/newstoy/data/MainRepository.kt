package com.example.newstoy.data

import androidx.lifecycle.LiveData
import com.example.newstoy.data.local.NewsData
import com.example.newstoy.di.component.DaggerApiComponent
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 *  메인 화면에서의 상호작용에 사용되는 repository
 */
class MainRepository private constructor(private val dao: MainDao) {

    private lateinit var disposable: Disposable


    fun getNewsList(): LiveData<List<NewsData>> {
//        if (dao.getNewsList().value!!.isEmpty()) {
//            doTestSearch()
//        }

        return dao.getNewsList()
    }

    fun doTestSearch() {
        disposable = BasicClient().getApi().testQuery("kr", DaggerApiComponent.create().getApiKey())
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    dao.deleteNews()
                    Timber.tag("queryTest").d("result : ${it}")

                    dao.insertNewsTransaction(it.articles)

                    it.articles.forEach { news ->
                        Timber.tag("queryTest").d("news : $news")
                    }

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
