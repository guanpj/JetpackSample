package com.me.guanpj.appbase.ext

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> Activity.inflateViewBinding() = lazy {
    inflateViewBinding<T>(layoutInflater).apply { setContentView(root) }
}

inline fun <reified T : ViewBinding> inflateViewBinding(layoutInflater: LayoutInflater) =
    T::class.java.getMethod("inflate", LayoutInflater::class.java).invoke(null, layoutInflater) as T

fun <T : ViewBinding> Activity.inflate(inflater: (LayoutInflater) -> T) = lazy {
    inflater(layoutInflater).apply { setContentView(root) }
    //with(inflater(layoutInflater)) { setContentView(root) }
    //inflater(layoutInflater).run { setContentView(root) }
}