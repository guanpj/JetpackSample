package com.me.guanpj.appbase

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 *
 * @author guanpengjie
 * @date 2022/8/26
 */
abstract class BaseBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewAndData()
    }

    abstract fun initViewAndData()
}