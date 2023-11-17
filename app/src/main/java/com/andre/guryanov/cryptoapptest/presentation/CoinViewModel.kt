package com.andre.guryanov.cryptoapptest.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andre.guryanov.cryptoapptest.data.repository.CoinRepositoryImpl
import com.andre.guryanov.cryptoapptest.domain.GetCoinInfoListUseCase
import com.andre.guryanov.cryptoapptest.domain.GetCoinInfoUseCase
import com.andre.guryanov.cryptoapptest.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repo)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)


    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


    init {
        loadDataUseCase()
    }

}