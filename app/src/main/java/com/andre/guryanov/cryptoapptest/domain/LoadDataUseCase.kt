package com.andre.guryanov.cryptoapptest.domain

import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val repo: CoinRepository
) {

    operator fun invoke() = repo.loadData()
}