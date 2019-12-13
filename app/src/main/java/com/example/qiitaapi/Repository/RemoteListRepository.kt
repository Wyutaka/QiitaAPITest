package com.example.qiitaapi.Repository

import com.example.qiitaapi.Model.ItemModel

interface RemoteListRepository {
    suspend fun getlist(searchWord: String): List<ItemModel>
}
