package com.run3wide.bitness.pricing.infrastructure.coinbase

import com.run3wide.bitness.configuration.DefaultConstructor

@DefaultConstructor
data class CoinbaseExchangeRateWrapper(
    val data: CoinbaseExchangeRate,
) {

    fun amount(): Double {
        return data.amount
    }

    fun currency(): String {
        return data.currency
    }
}
