package com.example.qiitaapi.Network

import com.example.qiitaapi.Model.ItemModel
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaApi {
    @GET("/api/v2/items")
    suspend fun getlists(
        @Query("query") query: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") parPage: Int = 60
    ): List<ItemModel>

    companion object {
        fun create(): QiitaApi {
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("http://qiita.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(QiitaApi::class.java)
        }
    }
}
