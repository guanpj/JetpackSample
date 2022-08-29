package com.me.guanpj.module_risk_level.ui

import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.appbase.ext.inflate
import com.me.guanpj.appbase.util.DialogLoadingUtils
import com.me.guanpj.module_risk_level.bean.DataTypeEnum
import com.me.guanpj.module_risk_level.bean.RiskLevelDetailBean
import com.me.guanpj.module_risk_level.databinding.ActivityRiskLevelBinding
import com.me.guanpj.module_risk_level.viewmodel.RiskLevelViewModel

@Route(path = ARouterConfig.RISK_LEVEL)
class RiskLevelActivity : BaseActivity() {

    private val mViewBinding by inflate(ActivityRiskLevelBinding::inflate)
    private val riskLevelViewModel by viewModels<RiskLevelViewModel>()

    override fun initViewAndData() {
        mViewBinding.toolbar.setNavigationOnClickListener {
            finish()
        }
        mViewBinding.rvData.layoutManager = LinearLayoutManager(this)
        initData()
    }

    private fun initData() {
        DialogLoadingUtils.showLoading(this, "请稍后")
        riskLevelViewModel.getRiskLevelMessage().observe(this) {
            DialogLoadingUtils.cancel()
            it?.let {
                if (it.error_code == 0) {
                    mViewBinding.bean = it.result
                    val list = mutableListOf<RiskLevelDetailBean>()
                    val highTitle = RiskLevelDetailBean()
                    highTitle.dataType = DataTypeEnum.DATA_IS_HIGH_TITLE.ordinal
                    list.add(highTitle)
                    it.result?.high_list?.let {
                        list.addAll(it)
                    }
                    val middleTitle = RiskLevelDetailBean()
                    middleTitle.dataType = DataTypeEnum.DATA_IS_MIDDLE_TITLE.ordinal
                    list.add(middleTitle)
                    it.result?.middle_list?.let { middle ->
                        list.addAll(middle)
                    }
                    val riskLevelAdapter = RiskLevelMessageAdapter(list)
                    mViewBinding.rvData.adapter = riskLevelAdapter
                }
            }
        }
    }
}