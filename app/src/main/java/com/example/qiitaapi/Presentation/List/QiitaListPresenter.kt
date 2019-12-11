package com.example.qiitaapi.Presentation.List

import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import bindLaunch
import com.example.qiitaapi.Repository.RemoteListRepository
import com.example.qiitaapi.Util.QiitaAPIApplication

class QiitaListPresenter(
    private var view: QiitaListView?,
    private var context: Context,
    private val qiitaRepository: RemoteListRepository = context.QiitaAPIApplication.qiitaListRepository
) {
    fun onDestroy() {
        view = null
    }

    inner class OnKeyListener : View.OnKeyListener {
        override fun onKey(editText: View?, keyCode: Int, keyEvent: KeyEvent): Boolean {
            if (keyEvent.action != KeyEvent.ACTION_UP || keyCode != KeyEvent.KEYCODE_ENTER) {
                return false
            }

            val searchText = editText as EditText
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)

            var text = searchText.text.toString()
            view?.bindLaunch {
                val list = qiitaRepository.getlist(text)
                view?.showList(list)
            }
            return true
        }
    }


}