package com.me.guanpj.module_test_agency.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.me.guanpj.appbase.network.HttpErrorDeal
import com.me.guanpj.module_test_agency.repository.AgencyRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class AgencyViewModel : ViewModel() {
    fun getAgencyMessage(cityId: String) = flow {
        emit(AgencyRepository().getAgencyMessage(cityId))
    }.catch {
        if (it is Exception) {
            HttpErrorDeal.dealHttpError(it)
        }
        emit(null)
    }.asLiveData()
}