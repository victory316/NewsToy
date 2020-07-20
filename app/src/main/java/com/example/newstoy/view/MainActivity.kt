package com.example.newstoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import com.example.newstoy.R
import com.example.newstoy.databinding.ActivityMainBinding
import com.example.newstoy.util.InjectorUtils
import com.example.newstoy.view.fragments.FavoriteFragment
import com.example.newstoy.view.fragments.NewsFeedFragment
import com.example.newstoy.view.fragments.SearchFragment
import com.example.newstoy.view.fragments.SettingsFragment
import com.example.newstoy.viewmodel.MainViewModel
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setupMotion()

        setContentView(binding.root)
        setupFragment(NewsFeedFragment.newInstance("ho", "ha"), "page_1")

        setupNavMenu()
    }

    private fun setupMotion() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
    }

    private fun setupFragment(fragment: Fragment, tag: String) {
        Timber.d("fragment stack : ${supportFragmentManager.backStackEntryCount}")

        // 1. Fragment가 존재하지 않으면 새롭게 생성한다.
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.frameLayout.id, fragment, tag)
                .addToBackStack(tag)
                .commit()

            Timber.d("adding fragment : $fragment with tag $tag")
        } else {

            // 2. Fragment가 존재할 경우 backstack에서 pop한다.
            supportFragmentManager.popBackStack(tag, 0)
            Timber.d("popping fragment : $fragment with tag $tag")
        }
    }

    private fun setupNavMenu() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.page_1 -> {
                    setupFragment(NewsFeedFragment.newInstance("ho", "ha"), "page_1")
                }

                R.id.page_2 -> {
                    setupFragment(SearchFragment.newInstance("ho", "ha"), "page_2")
                }

                R.id.page_3 -> {
                    setupFragment(FavoriteFragment.newInstance("ho", "ha"), "page_3")
                }

                R.id.page_4 -> {
                    setupFragment(SettingsFragment.newInstance("ho", "ha"), "page_4")
                }
            }

            true
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) finish()

        super.onBackPressed()
    }
}