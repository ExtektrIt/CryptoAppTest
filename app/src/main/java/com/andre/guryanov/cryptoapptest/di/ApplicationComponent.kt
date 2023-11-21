package com.andre.guryanov.cryptoapptest.di

import android.app.Application
import androidx.fragment.app.Fragment
import com.andre.guryanov.cryptoapptest.presentation.CoinDetailFragment
import com.andre.guryanov.cryptoapptest.presentation.CoinListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: CoinListFragment)

    fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}