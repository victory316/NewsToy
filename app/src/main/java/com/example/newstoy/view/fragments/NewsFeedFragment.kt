package com.example.newstoy.view.fragments

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newstoy.databinding.FragmentNewsFeedBinding
import com.example.newstoy.util.InjectorUtils
import com.example.newstoy.view.NewsAdapter
import com.example.newstoy.viewmodel.MainViewModel
import androidx.lifecycle.observe
import com.example.newstoy.R
import com.example.newstoy.data.MainRepository
import com.example.newstoy.util.Constants.REQUEST_ID
import com.example.newstoy.view.DetailActivity
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFeedFragment : DaggerFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val mainViewModel: MainViewModel by viewModels {
        InjectorUtils.provideMainViewModel(this)
    }

    @Inject
    lateinit var binding: FragmentNewsFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentNewsFeedBinding.inflate(inflater, container, false)
        setupUi()

        mainViewModel.testSearch()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setupUi() {
        val layoutManager = LinearLayoutManager(requireActivity())
        val adapter = NewsAdapter(mainViewModel)

        with(binding) {
            allList.adapter = adapter
            allList.layoutManager = layoutManager

            refreshLayout.setOnRefreshListener {
                mainViewModel.testSearch()
            }
        }

        mainViewModel.newsData.observe(viewLifecycleOwner) {
            it.forEach { news ->
                Timber.tag("newsTest").d("adding : $news")
            }

            adapter.submitList(it)
        }

        mainViewModel.refreshStatus.observe(viewLifecycleOwner) {
            Timber.tag("refreshTest").d("refresh finish")

            binding.refreshLayout.isRefreshing = false
        }

        // Pair(A : id, B : View)
        mainViewModel.detailViewData.observe(viewLifecycleOwner) { pair ->

            val imagePair = Pair(pair.second[0].first, pair.second[0].second)
            val titlePair = Pair(pair.second[1].first, pair.second[1].second)
            val contentsPair = Pair(pair.second[2].first, pair.second[2].second)

            Timber.tag("pairTest").d("${imagePair}")

//            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                requireActivity(),
//                imagePair,
//                titlePair,
//                contentsPair
//            )


            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(),
                imagePair.first!!, imagePair.second!!
            )

            startActivity(
                Intent(requireContext(), DetailActivity::class.java)
                    .putExtra(REQUEST_ID, pair.first.index), options.toBundle()
            )
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFeedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFeedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}