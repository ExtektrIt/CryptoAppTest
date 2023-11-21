package com.andre.guryanov.cryptoapptest.di

import androidx.lifecycle.ViewModel
import com.andre.guryanov.cryptoapptest.presentation.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindCoinViewModel(viewModel: CoinViewModel): ViewModel
}