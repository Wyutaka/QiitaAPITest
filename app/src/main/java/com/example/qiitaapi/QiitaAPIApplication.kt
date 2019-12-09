package com.example.qiitaapi

import android.app.Application
import com.example.qiitaapi.Network.QiitaApi
import com.example.qiitaapi.Repository.RemoteListRepository
import com.example.qiitaapi.Repository.RemoteListRepositoryImpl
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QiitaAPIApplication : Application() {
    private val qiitaApi: QiitaApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.QIITA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(QiitaApi::class.java)
    }

    val qiitaListRepository: RemoteListRepository by lazy {
        RemoteListRepositoryImpl(qiitaApi)
    }
}