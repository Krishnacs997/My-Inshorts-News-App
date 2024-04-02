package com.example.myinshorts.provider

import android.app.Application
import com.example.myinshorts.Repo.GetREpo
import com.example.myinshorts.network.RestApiService

object RepositoryProvider {

    fun provideGetRepository(application: Application) : GetREpo {
        return GetREpo(RestApiService.create(application))
    }
}