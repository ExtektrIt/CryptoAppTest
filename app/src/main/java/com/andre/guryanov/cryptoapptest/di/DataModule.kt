package com.andre.guryanov.cryptoapptest.di

import android.app.Application
import com.andre.guryanov.cryptoapptest.data.database.AppDatabase
import com.andre.guryanov.cryptoapptest.data.database.CoinInfoDao
import com.andre.guryanov.cryptoapptest.data.network.ApiFactory
import com.andre.guryanov.cryptoapptest.data.network.ApiService
import com.andre.guryanov.cryptoapptest.data.repository.CoinRepositoryImpl
import com.andre.guryanov.cryptoapptest.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl) : CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}