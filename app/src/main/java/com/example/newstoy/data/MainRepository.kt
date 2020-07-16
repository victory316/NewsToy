package com.example.newstoy.data

/**
 *  메인 화면에서의 상호작용에 사용되는 repository
 */
class MainRepository private constructor(private val dao: MainDao) {

    companion object {

        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(dao: MainDao) =
            instance ?: synchronized(this) {
                instance ?: MainRepository(dao).also { instance = it }
            }
    }
}
