package com.andre.guryanov.cryptoapptest.di

import android.app.Application
import com.andre.guryanov.cryptoapptest.presentation.CoinApp
import com.andre.guryanov.cryptoapptest.presentation.CoinDetailFragment
import com.andre.guryanov.cryptoapptest.presentation.CoinListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class, WorkerModule::class])
interface ApplicationComponent {

    fun inject(fragment: CoinListFragment)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}