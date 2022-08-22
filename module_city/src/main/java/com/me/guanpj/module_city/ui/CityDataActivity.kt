package com.me.guanpj.module_city.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.module_city.databinding.ActivityCityDataBinding

@Route(path = ARouterConfig.CITY_DATA)
class CityDataActivity : BaseActivity<ActivityCityDataBinding>() {



    override fun getViewBinding(): ActivityCityDataBinding  = ActivityCityDataBinding.inflate(layoutInflater)
}