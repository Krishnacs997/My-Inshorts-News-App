package com.example.myinshorts.view.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myinshorts.DataClass.NewsArticlesList
import com.example.myinshorts.Repo.GetREpo
import com.example.myinshorts.provider.RepositoryProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsViewModel(application: Application)  : ViewModel() {

    private val newsDetailLiveData = MutableLiveData<ArrayList<NewsArticlesList>>()
    val newsDetailLiveData1: LiveData<ArrayList<NewsArticlesList>> = newsDetailLiveData

    private val getRepository: GetREpo = RepositoryProvider.provideGetRepository(application)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        // time out, json parsing errors
        /* val errorData = getNetworkErrorInfo(message = throwable.toString())
        _onMessageError.value = errorData
        _isViewLoading.postValue(false)*/
    }

    fun getNews() {

        viewModelScope.launch() {
            val response = getRepository.getNewsData()

            if (response.isSuccessful) {

                response.body()?.let {
                    newsDetailLiveData.value = it.articles
                }
                Log.d("", "$newsDetailLiveData")

            }

            //if(response.isCanceled)
        }

    }
}



