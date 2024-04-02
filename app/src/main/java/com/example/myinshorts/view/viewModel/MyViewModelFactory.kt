package com.example.myinshorts.view.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private var application: Application): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass == NewsViewModel::class.java) {
            NewsViewModel(application) as T
        } else{
            super.create(modelClass)
        }
    }
}