package com.me.guanpj.jetpack.sample

import com.alibaba.android.arouter.launcher.ARouter
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.jetpack.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initViewAndData() {
        mViewBinding.llAgency.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.AGENCY_MESSAGE).navigation()
        }

        mViewBinding.llRiskLevel.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.RISK_LEVEL).navigation()
        }

        mViewBinding.llTravel.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.TRAVEL_POLICY).navigation()
        }
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}