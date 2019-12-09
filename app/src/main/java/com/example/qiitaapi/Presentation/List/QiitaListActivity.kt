package com.example.qiitaapi.Presentation.List

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaapi.Model.CardModel
import com.example.qiitaapi.R
import kotlinx.android.synthetic.main.activity_main.*

class QiitaListActivity : AppCompatActivity(), QiitaListRecyclerViewHolder.ItemClickListner {
    private lateinit var qiitaListRecyclerView: RecyclerView
    private lateinit var qiitaListRecyclerViewAdapter: QiitaListRecyclerViewAdapter

    val list =
        arrayListOf(CardModel("kusa", "kusa"), CardModel("kusa", "kusa"), CardModel("kusa", "kusa"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_list)

        qiitaListRecyclerView = qiita_item_list
        qiitaListRecyclerView.adapter = QiitaListRecyclerViewAdapter(this, this, list)
        qiitaListRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }

}