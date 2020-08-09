package com.example.newstoy.data

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import com.example.newstoy.data.local.NewsData
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject

/**
 *  메인 화면에서의 상호작용에 사용되는 repository
 */
class MainRepository
@Inject constructor(private val dao: MainDao, private val testApi: BasicApi) {

    private lateinit var disposable: Disposable

    private var queryFinish = PublishSubject.create<Boolean>()

    fun getQueryFininsh(): PublishSubject<Boolean> {
        return queryFinish
    }

    fun getNewsList(): LiveData<List<NewsData>> {
        return dao.getNewsList()
    }

    fun getNewsWithId(id: Int): LiveData<NewsData> {
        return dao.getNewsWithId(id)
    }

    fun doTestSearch() {
        disposable = testApi.testQuery("kr", API_KEY)
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

                    queryFinish.onNext(true)

                }, {
                    Timber.tag("queryTest").d("error! : $it")
                }
            )
    }

    companion object {

        const val API_KEY = "198e76f861e24d5cac3780e47b72115d"

        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(dao: MainDao, api: BasicApi) =
            instance ?: synchronized(this) {
                instance ?: MainRepository(dao, api).also { instance = it }
            }
    }
}
