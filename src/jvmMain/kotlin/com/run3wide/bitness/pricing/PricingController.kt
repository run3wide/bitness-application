package com.run3wide.bitness.pricing

import dto.pricing.PriceDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PricingController {

    @GetMapping("/rest/prices")
    fun getBitcoinPrice(): List<PriceDto> {
        return listOf(
            PriceDto(
                38_000.00,
                "USD",
            )
        )
    }
}
