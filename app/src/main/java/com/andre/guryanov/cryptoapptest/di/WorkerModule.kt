package com.andre.guryanov.cryptoapptest.di

import androidx.work.ListenableWorker
import com.andre.guryanov.cryptoapptest.data.workers.ChildWorkerFactory
import com.andre.guryanov.cryptoapptest.data.workers.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkerFactory
}