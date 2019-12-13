package com.example.qiitaapi.Presentation.List

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaapi.Model.ItemModel
import com.example.qiitaapi.R
import com.squareup.picasso.Picasso

class QiitaListRecyclerViewAdapter(
    private val context: Context,
    private val itemClickListner: QiitaListView
) : RecyclerView.Adapter<QiitaListRecyclerViewHolder>() {

    private var qiitalistRecyclerView: RecyclerView? = null
    private val itemModelList: MutableList<ItemModel> = mutableListOf()

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
            it.itemTitle.text = itemModelList.get(position).title
            it.userName.text = itemModelList.get(position).user?.name.toString()
            it.likes.text = itemModelList.get(position).likes_count.toString()
            Picasso.with(context).load(itemModelList.get(position).user?.profile_image_url)
                .into(it.itemIcon)
        }
    }

    override fun getItemCount(): Int {
        return itemModelList.size
    }

    // アイテムを取得してみる
    fun getItem(position: Int): ItemModel {
        return itemModelList.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QiitaListRecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.card_list_item, parent, false)

        mView.setOnClickListener { view ->
            qiitalistRecyclerView?.let {
                itemClickListner.showDetail(view, it.getChildAdapterPosition(view))
            }
        }

        return QiitaListRecyclerViewHolder(mView)
    }

    fun update(aNew: List<ItemModel>) {
        val diffResult = DiffUtil.calculateDiff(RecyclerDiffCallback(itemModelList, aNew))
        itemModelList.clear()
        itemModelList.addAll(aNew)
        diffResult.dispatchUpdatesTo(this)
    }

    private class RecyclerDiffCallback(
        private val old: List<ItemModel>,
        private val aNew: List<ItemModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = aNew.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition].title == aNew[newItemPosition].title

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition] == aNew[newItemPosition]
    }

}