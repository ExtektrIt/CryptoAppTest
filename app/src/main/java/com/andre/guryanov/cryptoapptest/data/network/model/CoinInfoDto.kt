package com.andre.guryanov.cryptoapptest.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoDto(
    @SerializedName("PRICE")
    @Expose
    val price: String,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: String?,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: String?,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long?,

    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,

    @SerializedName("IMAGEURL")
    @Expose
    val imageURL: String?,
)
