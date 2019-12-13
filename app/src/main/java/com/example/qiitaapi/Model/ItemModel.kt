package com.example.qiitaapi.Model

data class ItemModel(
    val id: String?,
    val title: String?,
    val body: String?,
    val url: String?,
    val comments_count: Int?,
    val likes_count: Int?,
    val created_at: String?,
    val user: User?
)
