package com.example.qiitaapi.Presentation.List

import LifecycleScope
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qiitaapi.Model.ItemModel
import com.example.qiitaapi.R
import com.example.qiitaapi.Util.CardRecyclerView
import kotlinx.android.synthetic.main.activity_qiita_list.*

class QiitaListActivity : AppCompatActivity(), QiitaListView {
    private lateinit var qiitaListRecyclerViewAdapter: QiitaListRecyclerViewAdapter
    private lateinit var qiitaListRecyclerView: CardRecyclerView
    private lateinit var presenter: QiitaListPresenter
    override val scope = LifecycleScope(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_list)
        presenter = QiitaListPresenter(this, this)

        qiitaListRecyclerView = qiita_item_list
        qiitaListRecyclerViewAdapter = QiitaListRecyclerViewAdapter(this, this)
        qiitaListRecyclerView.adapter = qiitaListRecyclerViewAdapter
        qiitaListRecyclerView.layoutManager = LinearLayoutManager(this)
        search_menu_search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("test", "test")
                presenter.showList(requireNotNull(newText))
                return true
            }
        })
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showDetail(view: View, position: Int) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(
            this,
            Uri.parse(qiitaListRecyclerViewAdapter.getItem(position).url)
        )
    }

    override fun showList(list: List<ItemModel>) {
        qiitaListRecyclerViewAdapter.update(list)
    }

}
