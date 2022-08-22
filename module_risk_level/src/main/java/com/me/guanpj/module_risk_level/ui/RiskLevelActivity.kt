package com.me.guanpj.module_risk_level.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.module_risk_level.databinding.ActivityRiskLevelBinding

@Route(path = ARouterConfig.RISK_LEVEL)
class RiskLevelActivity : BaseActivity<ActivityRiskLevelBinding>() {



    override fun getViewBinding(): ActivityRiskLevelBinding = ActivityRiskLevelBinding.inflate(layoutInflater)
}