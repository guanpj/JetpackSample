package com.me.guanpj.jetpack.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.jetpack.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initEvent()
    }

    private fun initEvent() {
        mViewBinding.llAgency.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.AGENCY_MESSAGE).withString("name", "guanpj").navigation()
        }

        mViewBinding.llRiskLevel.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.RISK_LEVEL).navigation()
        }

        mViewBinding.llTravel.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.TRAVEL_POLICY)
        }
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}