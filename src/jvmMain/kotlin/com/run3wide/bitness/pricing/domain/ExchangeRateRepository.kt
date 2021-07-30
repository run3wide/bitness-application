package com.run3wide.bitness.pricing.domain

interface ExchangeRateRepository {

    fun getBtcExchangeRate(): ExchangeRate
}
