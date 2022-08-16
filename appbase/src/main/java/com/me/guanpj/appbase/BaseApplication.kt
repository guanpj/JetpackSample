package com.me.guanpj.appbase

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

class BaseApplication : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        ARouter.init(this)
        ARouter.openDebug()
    }
}