package com.me.guanpj.appbase.ext

import com.me.guanpj.appbase.widget.LoadingDialog

/**
 * 弹窗默认样式
 */
fun LoadingDialog.Builder.defaultDialogView(): LoadingDialog.Builder {
    setDialogSize(
        120f, 112f
    )
    return this
}
