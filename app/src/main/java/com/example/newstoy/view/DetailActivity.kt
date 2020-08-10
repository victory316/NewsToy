package com.example.newstoy.view

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.example.newstoy.databinding.ActivityDetailBinding
import com.example.newstoy.util.Constants.REQUEST_ID
import com.example.newstoy.viewmodel.DetailViewModel
import com.example.newstoy.viewmodel.MainViewModel
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var binding: ActivityDetailBinding

    @Inject
    lateinit var mainViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupMotion()
        setupViewModel()
        setupView()

        setContentView(binding.root)
    }

    private fun setupViewModel() {
        binding.viewModel = mainViewModel

        with(binding) {
            viewModel = mainViewModel
            lifecycleOwner = this@DetailActivity
        }
    }

    private fun setupMotion() {

        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false

        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(binding.detailImageView)
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 500
        }

        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(binding.detailImageView)
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 500
        }
    }

    private fun setupView() {
        Timber.tag("intent").d("${intent.getIntExtra(REQUEST_ID, 0)}")

        mainViewModel.loadNewsWithId(intent.getIntExtra(REQUEST_ID, 0))

        mainViewModel.detailData!!.observe(this) {
            Timber.tag("detailTest").d("loading : $it")
        }
    }
}