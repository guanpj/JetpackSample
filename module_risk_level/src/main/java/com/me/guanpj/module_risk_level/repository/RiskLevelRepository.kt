package com.me.guanpj.module_risk_level.repository

import com.me.guanpj.appbase.network.BaseReqData
import com.me.guanpj.appbase.network.RetrofitServiceBuilder
import com.me.guanpj.module_risk_level.api.RiskLevelApi
import com.me.guanpj.module_risk_level.bean.RiskLevelDataBean

class RiskLevelRepository {
    private val network = RetrofitServiceBuilder.createService(RiskLevelApi::class.java)

    suspend fun getRiskLevelMessage(): BaseReqData<RiskLevelDataBean>? = network?.getRiskLevelMessage()
}