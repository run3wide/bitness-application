package com.run3wide.bitness.pricing.controller

import com.run3wide.bitness.pricing.service.ExchangeRateService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import java.math.BigDecimal
import org.knowm.xchange.currency.Currency
import org.springframework.http.codec.ServerSentEvent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@Tags(Tag(name = "Exchange Rates"))
@RestController
class ExchangeRateController(
    private val exchangeRateService: ExchangeRateService,
) {

    @Operation(summary = "Stream current exchange rate in USD")
    @GetMapping("/rest/exchange-rates/{currency}/stream")
    fun streamUsdExchangeRate(
        @PathVariable currency: Currency = Currency.BTC,
    ): Flux<ServerSentEvent<BigDecimal>> {
        return exchangeRateService.getStream(currency)
    }

    @Operation(summary = "Current exchange rate in USD")
    @GetMapping("/rest/exchange-rates/{currency}")
    fun getUsdExchangeRate(
        @PathVariable currency: Currency = Currency.BTC,
    ): BigDecimal {
        return exchangeRateService.get(currency)
    }
}
