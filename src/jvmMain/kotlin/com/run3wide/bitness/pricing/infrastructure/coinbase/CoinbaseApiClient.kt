package com.run3wide.bitness.pricing.infrastructure.coinbase

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "nomicsApiClient",
    url = "https://api.coinbase.com/v2",
)
interface CoinbaseApiClient {

    @GetMapping("/prices/spot?currency=USD")
    fun getBitcoinExchangeRate(): CoinbaseExchangeRateWrapper
}
