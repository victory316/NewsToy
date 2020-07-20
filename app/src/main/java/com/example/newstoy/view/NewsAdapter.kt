package com.example.newstoy.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newstoy.data.local.NewsData
import com.example.newstoy.databinding.NewsDataItemBinding
import com.example.newstoy.viewmodel.MainViewModel

/**
 *  페이징 구현을 위한 PagedListAdapter
 */
class NewsAdapter(private val mainViewModel: MainViewModel) :
    ListAdapter<NewsData, RecyclerView.ViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = NewsDataItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

//        binding.viewModel = answersViewModel

        return ResultViewHolder(
            binding, mainViewModel
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            (holder as ResultViewHolder).bind(it)
        }
    }

    class ResultViewHolder(
        private val binding: NewsDataItemBinding,
        private val mainViewModel: MainViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NewsData) {

            // TODO News data 업데이트
            binding.apply {

                newsTitle.text = item.title
                imageUrl = item.urlToImage
                contents = item.description

                executePendingBindings()

                root.setOnClickListener {
                    val viewList = listOf(
                        Pair(titleView, "image_view"),
                        Pair(newsTitle, "title_string"),
                        Pair(newsContent, "contents_string")
                    )

                    mainViewModel.showNewsDetail(item, viewList)
                }
            }
        }
    }

    private class AccountDiffCallback : DiffUtil.ItemCallback<NewsData>() {
        override fun areItemsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.index == newItem.index
        }

        override fun areContentsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem == newItem
        }
    }
}