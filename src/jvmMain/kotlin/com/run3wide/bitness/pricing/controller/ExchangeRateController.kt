package com.run3wide.bitness.pricing.controller

import com.run3wide.bitness.pricing.service.ExchangeRateService
import dto.pricing.ExchangeRateDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tags(Tag(name = "Pricing"))
@RestController
class ExchangeRateController(
    private val exchangeRateService: ExchangeRateService,
) {

    @Operation(summary = "Get current price BTC exchange rate")
    @GetMapping("/rest/exchange-rates/BTC")
    fun getBitcoinExchangeRate(): ExchangeRateDto {
        return exchangeRateService.getBtcExchangeRate()
    }
}
