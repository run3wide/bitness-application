package com.run3wide.bitness.pricing

import dto.pricing.PriceDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tags(Tag(name = "Pricing"))
@RestController
class PricingController {

    @Operation(summary = "Get fake prices")
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
