package com.andre.guryanov.cryptoapptest.presentation

import android.app.Application
import com.andre.guryanov.cryptoapptest.di.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}