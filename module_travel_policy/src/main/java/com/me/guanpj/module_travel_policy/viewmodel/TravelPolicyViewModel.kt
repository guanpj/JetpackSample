package com.me.guanpj.module_travel_policy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.me.guanpj.appbase.network.HttpErrorDeal
import com.me.guanpj.module_travel_policy.repository.TravelPolicyRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class TravelPolicyViewModel : ViewModel() {
    fun getTravelPolicy(fromCityId: String, toCityId: String) = flow {
        emit(TravelPolicyRepository().getTravelPolicy(fromCityId, toCityId))
    }.catch {
        if (it is Exception) {
            HttpErrorDeal.dealHttpError(it)
        }
        emit(null)
    }.asLiveData()
}