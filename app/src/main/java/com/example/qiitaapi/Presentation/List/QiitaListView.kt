package com.example.qiitaapi.Presentation.List

import LifecycleScopeSupport
import android.view.View
import com.example.qiitaapi.Model.ItemModel

interface QiitaListView : LifecycleScopeSupport{
    fun showDetail(view: View, position: Int)
    fun showList(list: List<ItemModel>)
}