package com.me.guanpj.module_city.ui

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.me.guanpj.appbase.BaseActivity
import com.me.guanpj.appbase.config.ARouterConfig
import com.me.guanpj.appbase.config.ParametersConfig
import com.me.guanpj.appbase.config.ResultCodeConfig
import com.me.guanpj.appbase.util.DialogLoadingUtils
import com.me.guanpj.module_city.R
import com.me.guanpj.module_city.bean.CityDataBean
import com.me.guanpj.module_city.databinding.ActivityCityDataBinding
import com.me.guanpj.module_city.viewmodel.CityDataViewModel

@Route(path = ARouterConfig.CITY_DATA)
class CityDataActivity : BaseActivity<ActivityCityDataBinding>() {

    private val cityDataViewModel by viewModels<CityDataViewModel>()
    val cityList = mutableListOf<CityDataBean.CityBean>()

    override fun initViewAndData() {
        mViewBinding.toolbar.setOnClickListener {
            finish()
        }
        //索引滚动
        mViewBinding.indexView.setOnIndexChangeListener(object : IndexView.OnIndexChangeListener {
            override fun onIndexChange(word: String?) {
                mViewBinding.tvIndex.visibility = View.VISIBLE
                mViewBinding.tvIndex.text = word
                word?.let {
                    cityList.let { it ->
                        it.forEachIndexed { position, data ->
                            if (word == data.firstLetter) {
                                mViewBinding.rvData.scrollToPosition(position)
                                return
                            }
                        }
                    }
                }
            }

            override fun uplift() {
                mViewBinding.tvIndex.visibility = View.GONE
            }

        })
        mViewBinding.rvData.layoutManager = LinearLayoutManager(this)

        initData()
    }

    private fun initData() {
        DialogLoadingUtils.showLoading(this, getString(R.string.wait_please))
        cityDataViewModel.getCityData().observe(this) {
            DialogLoadingUtils.cancel()
            it?.let {
                if (it.error_code == 0) {
                    //请求成功
                    it.result?.let { list ->
                        for (i in list.indices) {
                            val data = list[i].citys
                            data?.let { data ->
                                for (index in data.indices) {
                                    cityList.add(data[index])
                                }
                            }
                        }
                        cityList.sort()
                        val cityDataAdpter = CityDataAdapter(cityList,
                            callback = { position, data ->
                                //选择数据回调
                                val intent = Intent()
                                intent.putExtra(ParametersConfig.CITY_ID, data.city_id)
                                intent.putExtra(ParametersConfig.CITY_NAME, data.city)
                                setResult(
                                    ResultCodeConfig.RESULE_CODE_SELECT_CITY_SUCCESS,
                                    intent
                                )
                                finish()
                            })
                        mViewBinding.rvData.adapter = cityDataAdpter

                    }
                }
            }
        }
    }

    override fun getViewBinding(): ActivityCityDataBinding  = ActivityCityDataBinding.inflate(layoutInflater)
}