package com.me.guanpj.appbase.util

import android.content.Context
import com.hlq.appbase.expand.defaultDialogView
import com.hlq.appbase.tools.LoadingDialog

object DialogLoadingUtils {

    private var dialog: LoadingDialog? = null

    /**
     * 显示等待框
     */
    fun showLoading(context: Context, mes: String) {

        dialog?.apply {
            if (isShowing) {
                cancel()
            }
        }

        dialog = LoadingDialog.Builder(context)
            .defaultDialogView()
            .setBootomDesc(mes)
            .create()
        dialog!!.show()
    }


    /**
     * 取消
     */
    fun cancel() {
        dialog?.cancel()
    }
}