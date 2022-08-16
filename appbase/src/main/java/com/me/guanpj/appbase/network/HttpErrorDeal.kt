package com.me.guanpj.appbase.network

import com.me.guanpj.appbase.BaseApplication
import com.me.guanpj.appbase.R
import com.me.guanpj.appbase.util.ToastUtil
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import kotlinx.coroutines.CancellationException

object HttpErrorDeal {

    /**
     * 处理 http异常
     * @param error 异常信息
     * @param deal 异常时处理方法
     */
    fun dealHttpError(error: Throwable, deal: (() -> Unit)? = null) {
        when (error) {
            is SocketException -> {
                ToastUtil.shortShow(BaseApplication.context.getString(R.string.server_connection_abnormal))
            }
            is HttpException -> {
                ToastUtil.shortShow(BaseApplication.context.getString(R.string.server_connection_failed))
            }
            is SocketTimeoutException -> {
                ToastUtil.shortShow(BaseApplication.context.getString(R.string.request_timed_out))
            }
            is IOException -> {
                ToastUtil.shortShow(BaseApplication.context.getString(R.string.server_connection_failed))
            }
            is CancellationException -> {
                //协程被取消 这里是正常的 不提示
            }
            else -> {
                error.message?.let {
                    if (it.isNotEmpty()) {
                        ToastUtil.shortShow(it)
                    } else {
                        ToastUtil.shortShow(BaseApplication.context.getString(R.string.null_pointer_exception))
                    }
                }
            }
        }

        if (deal != null) {
            deal()
        }
    }
}