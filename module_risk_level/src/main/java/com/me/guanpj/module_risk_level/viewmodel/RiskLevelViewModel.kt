package com.me.guanpj.module_risk_level.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.me.guanpj.appbase.network.HttpErrorDeal
import com.me.guanpj.module_risk_level.repository.RiskLevelRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class RiskLevelViewModel : ViewModel() {
    fun getRiskLevelMessage() = flow {
        emit(RiskLevelRepository().getRiskLevelMessage())
    }.catch {
        if (it is Exception) {
            HttpErrorDeal.dealHttpError(it)
        }
        emit(null)
    }.asLiveData()
}