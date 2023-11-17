package com.andre.guryanov.cryptoapptest.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.andre.guryanov.cryptoapptest.data.database.AppDatabase
import com.andre.guryanov.cryptoapptest.data.mapper.CoinMapper
import com.andre.guryanov.cryptoapptest.data.network.ApiFactory
import com.andre.guryanov.cryptoapptest.data.workers.RefreshDataWorker
import com.andre.guryanov.cryptoapptest.domain.CoinInfo
import com.andre.guryanov.cryptoapptest.domain.CoinRepository
import kotlinx.coroutines.delay

class CoinRepositoryImpl(
    private val application: Application
): CoinRepository {

    private val coinInfoDao = AppDatabase.getInstance(application).coinInfoDao()

    private val mapper = CoinMapper()

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getPriceList().map { coinInfoDbModelList ->
            coinInfoDbModelList.map { coinInfoDbModel ->
                mapper.mapDbModelToEntity(coinInfoDbModel)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}