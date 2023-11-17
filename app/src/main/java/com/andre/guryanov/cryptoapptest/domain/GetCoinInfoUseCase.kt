package com.andre.guryanov.cryptoapptest.domain

class GetCoinInfoUseCase(
    private val repo: CoinRepository,
) {

    operator fun invoke(fromSymbol: String) = repo.getCoinInfo(fromSymbol)
}