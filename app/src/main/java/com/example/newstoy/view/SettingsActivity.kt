package com.example.newstoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newstoy.R

/**
 * 메인의 Setting 페이지에서 상세 내용을 보여주기 위한 Activity
 */
class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}