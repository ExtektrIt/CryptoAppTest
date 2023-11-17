package com.andre.guryanov.cryptoapptest.data.mapper

import com.andre.guryanov.cryptoapptest.data.database.CoinInfoDao
import com.andre.guryanov.cryptoapptest.data.database.CoinInfoDbModel
import com.andre.guryanov.cryptoapptest.data.network.ApiFactory
import com.andre.guryanov.cryptoapptest.data.network.model.CoinInfoDto
import com.andre.guryanov.cryptoapptest.data.network.model.CoinInfoJsonContainerDto
import com.andre.guryanov.cryptoapptest.data.network.model.CoinNamesListDto
import com.andre.guryanov.cryptoapptest.domain.CoinInfo
import com.google.gson.Gson
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto) = CoinInfoDbModel(
            fromSymbol = dto.fromSymbol,
            toSymbol = dto.toSymbol,
            price = dto.price,
            lastUpdate = dto.lastUpdate,
            highDay = dto.highDay,
            lowDay = dto.lowDay,
            lastMarket = dto.lastMarket,
            imageURL = getFullImageURL(dto.imageURL)
    )

    fun mapJsonContainerToListCoinInfo(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObj = jsonContainer.json ?: return result
        val coinKeySet = jsonObj.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObj.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel) = CoinInfo (
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastUpdate = convertTimestampToTime(dbModel.lastUpdate),
        highDay = dbModel.highDay,
        lowDay = dbModel.lowDay,
        lastMarket = dbModel.lastMarket,
        imageURL = dbModel.imageURL
    )


    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        val r =  namesListDto.names?.map {
            it.coinName?.name
        }
        return r?.joinToString(",") ?: ""
    }

    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    private fun getFullImageURL(urlPart: String?) : String {
        return BASE_IMAGE_URL + urlPart
    }

    companion object {

        private const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}