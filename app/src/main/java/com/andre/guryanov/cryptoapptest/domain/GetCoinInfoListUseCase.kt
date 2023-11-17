package com.andre.guryanov.cryptoapptest.domain

class GetCoinInfoListUseCase(
    private val repo: CoinRepository
) {

    operator fun invoke() = repo.getCoinInfoList()
}