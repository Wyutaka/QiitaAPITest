package com.example.qiitaapi.Util

import android.content.Context
import com.example.qiitaapi.QiitaAPIApplication

val Context.QiitaAPIApplication: QiitaAPIApplication
    get() = applicationContext as QiitaAPIApplication