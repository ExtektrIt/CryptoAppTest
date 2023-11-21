package com.andre.guryanov.cryptoapptest.di

import android.app.Application
import com.andre.guryanov.cryptoapptest.data.database.AppDatabase
import com.andre.guryanov.cryptoapptest.data.database.CoinInfoDao
import com.andre.guryanov.cryptoapptest.data.repository.CoinRepositoryImpl
import com.andre.guryanov.cryptoapptest.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl) : CoinRepository

    companion object {

        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinInfoDao()
        }
    }
}