package com.example.qiitaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val webView = web_view
        val url = intent.getStringExtra("url")

        //リンクをタップしたときに標準ブラウザを起動させない
        webView.webViewClient = WebViewClient()

        //最初に投稿を表示　
        webView.loadUrl(url)
    }
}
