package com.andre.guryanov.cryptoapptest.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(
    val price: String,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val lastUpdate: Long?,
    @PrimaryKey
    val fromSymbol: String,
    val toSymbol: String?,
    val imageURL: String,
)
