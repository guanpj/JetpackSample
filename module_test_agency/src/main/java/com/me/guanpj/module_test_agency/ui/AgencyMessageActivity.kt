package com.me.guanpj.module_test_agency.ui

import android.content.Intent
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.appbase.config.ParametersConfig
import com.me.guanpj.appbase.config.RequestCodeConfig
import com.me.guanpj.appbase.config.ResultCodeConfig
import com.me.guanpj.appbase.util.DialogLoadingUtils
import com.me.guanpj.module_test_agency.R
import com.me.guanpj.module_test_agency.databinding.ActivityAgencyMessageBinding
import com.me.guanpj.module_test_agency.viewmodel.AgencyViewModel

@Route(path = ARouterConfig.AGENCY_MESSAGE)
class AgencyMessageActivity : BaseActivity<ActivityAgencyMessageBinding>() {

    private val agencyViewModel by viewModels<AgencyViewModel>()

    override fun initViewAndData() {
        mViewBinding.toolbar.setOnClickListener {
            finish()
        }
        //选择城市监听事件
        mViewBinding.tvCity.setOnClickListener {
            ARouter.getInstance().build(ARouterConfig.CITY_DATA)
                .navigation(this, RequestCodeConfig.REQUEST_CODE_SELECT_CITY)
        }
        mViewBinding.rvData.layoutManager = LinearLayoutManager(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RequestCodeConfig.REQUEST_CODE_SELECT_CITY
            && resultCode == ResultCodeConfig.RESULE_CODE_SELECT_CITY_SUCCESS) {
            val cityId = data?.getStringExtra(ParametersConfig.CITY_ID)
            val cityName = data?.getStringExtra(ParametersConfig.CITY_NAME)
            mViewBinding.tvCity.text = cityName
            cityId?.let {
                loadData(it)
            }
        }
    }

    private fun loadData(cityId: String) {
        DialogLoadingUtils.showLoading(this, getString(R.string.wait_please))
        agencyViewModel.getAgencyMessage(cityId).observe(this) {
            DialogLoadingUtils.cancel()
            it?.let {
                if (it.error_code == 0) {
                    it.result?.data?.let { data ->
                        mViewBinding.rvData.adapter = AgencyMessageAdapter(data)
                    }
                }
            }
        }
    }

    override fun getViewBinding(): ActivityAgencyMessageBinding = ActivityAgencyMessageBinding.inflate(layoutInflater)
}