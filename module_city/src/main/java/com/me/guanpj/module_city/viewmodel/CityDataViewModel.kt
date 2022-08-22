package com.me.guanpj.module_city.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.me.guanpj.appbase.network.HttpErrorDeal
import com.me.guanpj.appbase.repository.CityRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CityDataViewModel : ViewModel() {
    fun getCityData() = flow {
        emit(CityRepository().getCityData())
    }.catch {
        if (it is Exception) {
            HttpErrorDeal.dealHttpError(it)
        }
        emit(null)
    }.asLiveData()
}