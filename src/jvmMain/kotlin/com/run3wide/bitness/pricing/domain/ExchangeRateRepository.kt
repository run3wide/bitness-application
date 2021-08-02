package com.run3wide.bitness.pricing.domain

import org.knowm.xchange.currency.Currency

interface ExchangeRateRepository {

    fun get(currency: Currency): ExchangeRate
}
