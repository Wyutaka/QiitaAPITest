package com.example.qiitaapi.Repository

import com.example.qiitaapi.Model.Item

interface RemoteListRepository {
    suspend fun getlist(searchWord: String): List<Item>
}
