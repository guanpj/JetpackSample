package com.me.guanpj.appbase.repository

import com.me.guanpj.appbase.network.BaseReqData
import com.me.guanpj.appbase.network.RetrofitServiceBuilder
import com.me.guanpj.module_city.api.CityApi
import com.me.guanpj.module_city.bean.CityDataBean

class CityRepository {
    private val network = RetrofitServiceBuilder.createService(CityApi::class.java)

    suspend fun getCityData(): BaseReqData<List<CityDataBean>>? = network?.getCityData()
}