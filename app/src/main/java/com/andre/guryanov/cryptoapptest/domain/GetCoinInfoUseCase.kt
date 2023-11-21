package com.andre.guryanov.cryptoapptest.domain

import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(
    private val repo: CoinRepository,
) {

    operator fun invoke(fromSymbol: String) = repo.getCoinInfo(fromSymbol)
}