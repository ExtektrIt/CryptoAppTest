package com.andre.guryanov.cryptoapptest.presentation

import android.app.Application
import androidx.lifecycle.*
import com.andre.guryanov.cryptoapptest.data.repository.CoinRepositoryImpl
import com.andre.guryanov.cryptoapptest.domain.GetCoinInfoListUseCase
import com.andre.guryanov.cryptoapptest.domain.GetCoinInfoUseCase
import com.andre.guryanov.cryptoapptest.domain.LoadDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


    init {
        loadDataUseCase()
    }

}