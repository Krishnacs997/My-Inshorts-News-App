package com.example.myinshorts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myinshorts.DataClass.NewsArticlesList
import com.example.myinshorts.MainActivity
import com.example.myinshorts.databinding.NewsItemRowBinding

class ReelAdapter(val newsArticleList: ArrayList<NewsArticlesList>, val context: MainActivity) : RecyclerView.Adapter<ReelAdapter.ReelViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelAdapter.ReelViewHolder {
        val view: NewsItemRowBinding = NewsItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReelViewHolder(view)

    }


    override fun onBindViewHolder(holder: ReelAdapter.ReelViewHolder, position: Int) {
        val reelItem = newsArticleList[position]
        val itemControlarChiledView = holder as ReelViewHolder
        itemControlarChiledView.bind(reelItem)

    }

    override fun getItemCount(): Int {
        return newsArticleList.size
    }

    inner class ReelViewHolder(private val newsItem: NewsItemRowBinding) : RecyclerView.ViewHolder(newsItem.root) {
        fun bind(article: NewsArticlesList){

            article.urlToImage.let {
                Glide.with(context).load(article.urlToImage).into(newsItem.headLineImage)
            }
            article.title.let {
                newsItem.newsArticleHeadline.text = it
            }

            article.description.let {
                newsItem.newsArticleDescription.text = it
            }

            article.publishedAt.let {
                newsItem.newsArticleDate.text = it
            }

        }
    }
}