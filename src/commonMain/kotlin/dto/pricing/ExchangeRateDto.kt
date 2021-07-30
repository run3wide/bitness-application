package dto.pricing

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateDto(
    val amount: Double,
    val currency: String,
)
