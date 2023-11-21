package com.andre.guryanov.cryptoapptest.domain

import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(
    private val repo: CoinRepository
) {

    operator fun invoke() = repo.getCoinInfoList()
}