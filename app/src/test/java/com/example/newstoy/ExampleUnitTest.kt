package com.example.newstoy

import android.util.Log
import com.example.newstoy.di.DaggerMyComponent
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testHelloWorld() {
        println(DaggerMyComponent.create().getString())
    }
}