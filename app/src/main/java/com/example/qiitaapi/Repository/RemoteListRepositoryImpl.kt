package com.example.qiitaapi.Repository

import com.example.qiitaapi.Model.ItemModel
import com.example.qiitaapi.Network.QiitaApi

class RemoteListRepositoryImpl(private val api: QiitaApi) : RemoteListRepository {
    override suspend fun getlist(searchWord: String): List<ItemModel> = api.getlists(searchWord)
}