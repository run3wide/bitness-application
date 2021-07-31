package com.run3wide.bitness.pricing.infrastructure.coinbase

import com.run3wide.bitness.pricing.domain.ExchangeRate
import com.run3wide.bitness.pricing.domain.ExchangeRateRepository
import org.knowm.xchange.Exchange
import org.knowm.xchange.ExchangeFactory
import org.knowm.xchange.currency.CurrencyPair
import org.knowm.xchange.gemini.v1.GeminiExchange
import org.springframework.stereotype.Component

@Component
class CoinbaseExchangeRateRepository : ExchangeRateRepository {

    override fun getBtcExchangeRate(): ExchangeRate {
        val geminiExchange: Exchange = ExchangeFactory.INSTANCE.createExchange(GeminiExchange::class.java)
        return geminiExchange
            .marketDataService
            .getTicker(CurrencyPair.BTC_USD)
            .let { ExchangeRate(it.bid, "USD") }
    }
}
