package com.example.qiitaapi.Presentation.List

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaapi.R

class QiitaListRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val itemIcon: ImageView = view.findViewById(R.id.item_icon)
    val itemTitle: TextView = view.findViewById(R.id.item_title)
    val userName: TextView = view.findViewById(R.id.user_name)
}