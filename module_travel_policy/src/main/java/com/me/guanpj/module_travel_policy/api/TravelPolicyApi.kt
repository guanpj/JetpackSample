package com.me.guanpj.module_travel_policy.api

import com.me.guanpj.appbase.network.BaseApi
import com.me.guanpj.appbase.network.BaseReqData
import com.me.guanpj.module_travel_policy.bean.TravelPolicyReqBean
import retrofit2.http.GET
import retrofit2.http.Query

interface TravelPolicyApi {
    @GET("query")
    suspend fun getTravelPolicy(
        @Query("from") fromCityId: String,
        @Query("to") toCityId: String,
        @Query("key") key: String = BaseApi.KEY
    ): BaseReqData<TravelPolicyReqBean>
}