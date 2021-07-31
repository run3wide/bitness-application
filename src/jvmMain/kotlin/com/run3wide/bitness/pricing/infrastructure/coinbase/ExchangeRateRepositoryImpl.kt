package com.run3wide.bitness.pricing.infrastructure.coinbase

import com.run3wide.bitness.pricing.domain.ExchangeRate
import com.run3wide.bitness.pricing.domain.ExchangeRateRepository
import org.knowm.xchange.Exchange
import org.knowm.xchange.currency.Currency
import org.knowm.xchange.currency.CurrencyPair
import org.springframework.stereotype.Component

@Component
class ExchangeRateRepositoryImpl(
    private val exchange: Exchange,
) : ExchangeRateRepository {

    override fun get(currency: Currency): ExchangeRate {
        val currencyPair = currency.toUsdPair()
        return exchange
            .marketDataService
            .getTicker(currencyPair)
            .let { ExchangeRate(it.bid, "USD") }
    }

    private fun Currency.toUsdPair(): CurrencyPair {
        return CurrencyPair(this, Currency.USD)
    }
}
