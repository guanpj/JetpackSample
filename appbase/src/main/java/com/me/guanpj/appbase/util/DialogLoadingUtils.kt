package com.me.guanpj.appbase.util

import android.content.Context
import com.me.guanpj.appbase.widget.LoadingDialog
import com.me.guanpj.appbase.ext.defaultDialogView

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