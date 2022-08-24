package com.me.guanpj.module_test_agency.repository

import com.me.guanpj.appbase.network.RetrofitServiceBuilder
import com.me.guanpj.module_test_agency.api.AgencyApi

class AgencyRepository {
    private val network = RetrofitServiceBuilder.createService(AgencyApi::class.java)

    suspend fun getAgencyMessage(cityId: String) = network?.let { it.getAgencyMessage(cityId) }
}