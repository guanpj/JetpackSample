package com.me.guanpj.appbase.util

import android.widget.Toast
import com.hlq.appbase.BaseApplication

object ToastUtil {

    /**
     * 短提示
     * @param message 提示语
     */
    fun shortShow(message: String) {
        Toast.makeText(
            BaseApplication.context,
            message, Toast.LENGTH_SHORT
        ).show()
    }

    /**
     * 长提示
     * @param message 提示语
     */
    fun longShow(message: String) {
        Toast.makeText(
            BaseApplication.context,
            message, Toast.LENGTH_LONG
        ).show()
    }

}