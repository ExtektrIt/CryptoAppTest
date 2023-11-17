package com.andre.guryanov.cryptoapptest.domain

class LoadDataUseCase(
    private val repo: CoinRepository
) {

    operator fun invoke() = repo.loadData()
}