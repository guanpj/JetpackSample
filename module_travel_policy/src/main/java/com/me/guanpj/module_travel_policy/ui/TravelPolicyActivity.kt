package com.me.guanpj.module_travel_policy.ui

import android.content.Intent
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.appbase.config.ParametersConfig
import com.me.guanpj.appbase.config.RequestCodeConfig
import com.me.guanpj.appbase.config.ResultCodeConfig
import com.me.guanpj.appbase.ext.inflate
import com.me.guanpj.appbase.util.DialogLoadingUtils
import com.me.guanpj.module_travel_policy.databinding.ActivityTravelPolicyBinding
import com.me.guanpj.module_travel_policy.viewmodel.TravelPolicyViewModel

@Route(path = ARouterConfig.TRAVEL_POLICY)
class TravelPolicyActivity : BaseActivity() {

    private val mViewBinding by inflate(ActivityTravelPolicyBinding::inflate)
    private val travelPolicyViewModel by viewModels<TravelPolicyViewModel>()

    var fromCityId: String? = null
    var toCityId: String? = null

    override fun initViewAndData() {
        mViewBinding.toolbar.setNavigationOnClickListener {
            finish()
        }
        //选择出发地
        mViewBinding.tvFromCity.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.CITY_DATA)
                .navigation(this, RequestCodeConfig.REQUEST_CODE_SELECT_FROM_CITY)
        }
        //选择目的地
        mViewBinding.tvToCity.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.CITY_DATA)
                .navigation(this, RequestCodeConfig.REQUEST_CODE_SELECT_TO_CITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            RequestCodeConfig.REQUEST_CODE_SELECT_FROM_CITY -> {
                //选择出发地
                if (resultCode == ResultCodeConfig.RESULE_CODE_SELECT_CITY_SUCCESS) {
                    fromCityId = data?.getStringExtra(ParametersConfig.CITY_ID)
                    mViewBinding.tvFromCity.text = data?.getStringExtra(ParametersConfig.CITY_NAME)
                    loadData()
                }
            }
            RequestCodeConfig.REQUEST_CODE_SELECT_TO_CITY -> {
                //选择目的地
                if (resultCode == ResultCodeConfig.RESULE_CODE_SELECT_CITY_SUCCESS) {
                    toCityId = data?.getStringExtra(ParametersConfig.CITY_ID)
                    mViewBinding.tvToCity.text = data?.getStringExtra(ParametersConfig.CITY_NAME)
                    loadData()
                }
            }
        }
    }

    private fun loadData() {
        fromCityId?.let { fromCityId ->
            toCityId?.let { toCityId ->
                DialogLoadingUtils.showLoading(this, "请稍后")
                travelPolicyViewModel.getTravelPolicy(fromCityId, toCityId)
                    .observe(this) {
                        DialogLoadingUtils.cancel()
                        it?.let {
                            if (it.error_code == 0) {
                                mViewBinding.bean = it.result
                            }
                        }
                    }
            }
        }
    }
}