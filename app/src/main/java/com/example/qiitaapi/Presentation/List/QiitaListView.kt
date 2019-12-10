package com.example.qiitaapi.Presentation.List

import LifecycleScopeSupport
import android.view.View

interface QiitaListView : LifecycleScopeSupport{
    fun onItemClick(view: View, position: Int)
    fun showDetail(view: View, position: Int)
}