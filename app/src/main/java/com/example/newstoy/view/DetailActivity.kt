package com.example.newstoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.newstoy.R
import com.example.newstoy.databinding.ActivityDetailBinding
import com.example.newstoy.databinding.ActivityMainBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setupMotion()

        setContentView(binding.root)
    }

    private fun setupMotion() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false

        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(binding.detailConstraintParent)
            pathMotion = MaterialArcMotion()
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 300
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(binding.detailConstraintParent)
            pathMotion = MaterialArcMotion()
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 250
        }
    }
}