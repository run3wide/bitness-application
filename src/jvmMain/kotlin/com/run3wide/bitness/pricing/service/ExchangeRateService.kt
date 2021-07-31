package com.run3wide.bitness.pricing.service

import com.run3wide.bitness.pricing.domain.ExchangeRateRepository
import dto.pricing.ExchangeRateDto
import org.springframework.stereotype.Service

@Service
class ExchangeRateService(
    private val exchangeRateRepository: ExchangeRateRepository,
) {

    fun getBtcExchangeRate(): ExchangeRateDto {
        return exchangeRateRepository.getBtcExchangeRate()
            .let { ExchangeRateDto(it.amount.toDouble(), it.currency) }
    }
}
