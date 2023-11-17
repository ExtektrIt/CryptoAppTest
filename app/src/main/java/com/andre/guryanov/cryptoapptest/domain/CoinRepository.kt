package com.andre.guryanov.cryptoapptest.domain

import androidx.lifecycle.LiveData

interface CoinRepository {

    fun getCoinInfoList() : LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String) : LiveData<CoinInfo>

    fun loadData()

}