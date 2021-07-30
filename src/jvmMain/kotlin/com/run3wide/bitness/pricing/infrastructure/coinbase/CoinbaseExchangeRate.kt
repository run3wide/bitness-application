package com.run3wide.bitness.pricing.infrastructure.coinbase

import com.run3wide.bitness.configuration.DefaultConstructor

@DefaultConstructor
data class CoinbaseExchangeRate(
    val base: String,
    val currency: String,
    val amount: Double,
)
