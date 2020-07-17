package com.example.newstoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newstoy.R
import com.example.newstoy.databinding.ActivityDetailBinding
import com.example.newstoy.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}