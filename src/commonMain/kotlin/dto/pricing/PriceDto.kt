package dto.pricing

import kotlinx.serialization.Serializable

@Serializable
data class PriceDto(
    val amount: Double,
    val currency: String,
)
