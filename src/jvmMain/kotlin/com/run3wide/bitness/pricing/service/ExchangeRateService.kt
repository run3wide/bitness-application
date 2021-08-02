package com.run3wide.bitness.pricing.service

import com.run3wide.bitness.pricing.domain.ExchangeRateRepository
import java.math.BigDecimal
import java.time.Duration
import java.util.UUID
import org.knowm.xchange.currency.Currency
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.codec.ServerSentEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ExchangeRateService(
    private val exchangeRateRepository: ExchangeRateRepository,
    @Value("\${streaming.interval-in-ms}") private val streamingIntervalInMs: Long,
) {

    fun getStream(currency: Currency): Flux<ServerSentEvent<BigDecimal>> {
        return Flux.interval(Duration.ofMillis(streamingIntervalInMs))
            .map {
                ServerSentEvent.builder<BigDecimal>()
                    .id(UUID.randomUUID().toString())
                    .data(exchangeRateRepository.get(currency).amount)
                    .event("${currency}_PRICE")
                    .build()
            }
    }

    fun get(currency: Currency): BigDecimal {
        return exchangeRateRepository.get(currency)
            .amount
    }
}
