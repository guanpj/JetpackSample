package com.me.guanpj.appbase.ext

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

fun List<String>?.splitData(): String {
    val stringBuffer = StringBuffer()
    if (!isNullOrEmpty()) {
        for (i in this.indices) {
            stringBuffer.append(this[i] + "\n")
        }
    }
    return stringBuffer.toString()
}