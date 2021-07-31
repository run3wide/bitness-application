package com.run3wide.bitness.pricing.infrastructure.coinbase

import org.knowm.xchange.Exchange
import org.knowm.xchange.ExchangeFactory
import org.knowm.xchange.gemini.v1.GeminiExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExchangeConfiguration {

    @Bean
    fun exchange(): Exchange {
        return ExchangeFactory.INSTANCE.createExchange(GeminiExchange::class.java)
    }
}
