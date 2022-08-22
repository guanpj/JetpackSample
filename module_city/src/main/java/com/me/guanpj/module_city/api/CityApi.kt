package com.me.guanpj.module_city.api

import com.me.guanpj.appbase.network.BaseApi
import com.me.guanpj.appbase.network.BaseReqData
import com.me.guanpj.module_city.bean.CityDataBean
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {
    @GET("citys")
    suspend fun getCityData(@Query("key") key: String = BaseApi.KEY) : BaseReqData<List<CityDataBean>>
}