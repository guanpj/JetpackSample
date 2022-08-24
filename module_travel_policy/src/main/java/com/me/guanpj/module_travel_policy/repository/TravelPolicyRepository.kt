package com.me.guanpj.module_travel_policy.repository

import com.me.guanpj.appbase.network.RetrofitServiceBuilder
import com.me.guanpj.module_travel_policy.api.TravelPolicyApi

class TravelPolicyRepository {
    private val network = RetrofitServiceBuilder.createService(TravelPolicyApi::class.java)

    suspend fun getTravelPolicy(fromCityId: String, toCityId: String) = network?.getTravelPolicy(fromCityId, toCityId)
}