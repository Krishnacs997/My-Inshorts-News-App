package com.example.myinshorts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.myinshorts.DataClass.NewsArticlesList
import com.example.myinshorts.databinding.ActivityMainBinding
import com.example.myinshorts.view.ReelAdapter
import com.example.myinshorts.view.viewModel.MyViewModelFactory
import com.example.myinshorts.view.viewModel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var url :String

    private lateinit var api_key : String

    private lateinit var articleList : ArrayList<NewsArticlesList>
    private lateinit var viewModel : NewsViewModel
    private var arrayString = ArrayList<String>()

    private lateinit var reelAdapter: ReelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        articleList = ArrayList()
        setupViewModel()
        setUpCall()
        setUpUI()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, MyViewModelFactory(this.application)).get(NewsViewModel::class.java)
        viewModel.newsDetailLiveData1.observe(this, resderNewsList)
        viewModel.isViewLoading.observe(this, viewLoadingRender)
    }

    private val viewLoadingRender = Observer<Boolean> {
        it.let {
            if(it){
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private val resderNewsList = Observer<ArrayList<NewsArticlesList>>{
        articleList.addAll(it)
        setUpUI()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setUpUI() {


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNewsList.layoutManager = layoutManager

        if (articleList.isNotEmpty()) {
            reelAdapter = ReelAdapter(articleList, this)
            binding.rvNewsList.adapter = reelAdapter

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(binding.rvNewsList)
        }

    }

    private fun setUpCall() {
        viewModel.getNews()
    }
}