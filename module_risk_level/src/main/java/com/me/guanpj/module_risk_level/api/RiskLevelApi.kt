package com.me.guanpj.module_risk_level.api

import com.me.guanpj.appbase.network.BaseApi
import com.me.guanpj.appbase.network.BaseReqData
import com.me.guanpj.module_risk_level.bean.RiskLevelDataBean
import retrofit2.http.GET
import retrofit2.http.Query

interface RiskLevelApi {
    @GET("risk")
    suspend fun getRiskLevelMessage(@Query("key") key: String = BaseApi.KEY): BaseReqData<RiskLevelDataBean>
}