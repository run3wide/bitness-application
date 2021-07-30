package com.run3wide.bitness.pricing.infrastructure.coinbase

import com.run3wide.bitness.pricing.domain.ExchangeRate
import com.run3wide.bitness.pricing.domain.ExchangeRateRepository
import org.springframework.stereotype.Component

@Component
class CoinbaseExchangeRateRepository(
    private val coinbaseApiClient: CoinbaseApiClient
) : ExchangeRateRepository {

    override fun getBtcExchangeRate(): ExchangeRate {
        return coinbaseApiClient.getBitcoinExchangeRate()
            .let { ExchangeRate(it.amount(), it.currency()) }
    }
}
