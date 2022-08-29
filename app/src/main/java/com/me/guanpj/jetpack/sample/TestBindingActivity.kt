package com.me.guanpj.jetpack.sample

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.databinding.ActivityTestBindingBinding
import com.me.guanpj.appbase.ext.inflate
import com.me.guanpj.appbase.ext.inflateViewBinding

/**
 *
 * @author guanpengjie
 * @date 2022/8/26
 */
class TestBindingActivity : BaseActivity() {
    val binding by lazy { inflateViewBinding<ActivityTestBindingBinding>(layoutInflater) }

    val binding1 by inflateViewBinding<ActivityTestBindingBinding>()

    val binding2 by inflate(ActivityTestBindingBinding::inflate)

    val binding3 by inflate {
        ActivityTestBindingBinding.inflate(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val binding0 = ActivityTestBindingBinding.inflate(layoutInflater)
        //binding0.text.text = "hhh";
        //setContentView(binding0.root)

        //setContentView(binding.root)
    }

    override fun initViewAndData() {
        //binding.text.text = "abc"
        //binding1.text.text = "aaaa"
        //binding.text.text = "dfg"
    }

}