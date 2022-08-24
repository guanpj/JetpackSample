package com.me.guanpj.module_test_agency.api

import com.me.guanpj.appbase.network.BaseApi
import com.me.guanpj.appbase.network.BaseReqData
import com.me.guanpj.module_test_agency.bean.AgencyMessageDataBean
import retrofit2.http.GET
import retrofit2.http.Query

interface AgencyApi {
    @GET("hsjg")
    suspend fun getAgencyMessage(
        @Query("city_id") city_id: String,
        @Query("key") key: String = BaseApi.KEY
    ): BaseReqData<AgencyMessageDataBean>
}