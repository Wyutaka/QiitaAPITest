package com.example.qiitaapi.Presentation.List

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaapi.Model.CardModel
import com.example.qiitaapi.R

class QiitaListRecyclerViewAdapter(
    private val context: Context,
    private val itemClickListner: QiitaListRecyclerViewHolder.ItemClickListner,
    private val itemList: List<CardModel>
) : RecyclerView.Adapter<QiitaListRecyclerViewHolder>() {

    private var qiitalistRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        qiitalistRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        qiitalistRecyclerView = null

    }

    override fun onBindViewHolder(holder: QiitaListRecyclerViewHolder, position: Int) {
        holder.let {
            it.itemTitle.text = itemList.get(position).itemTitle
            it.userName.text = itemList.get(position).userName
            it.itemIcon.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QiitaListRecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.list_item, parent, false)

        mView.setOnClickListener { view ->
            qiitalistRecyclerView?.let {
                itemClickListner.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return QiitaListRecyclerViewHolder(mView)
    }

}
