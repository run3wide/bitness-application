package com.run3wide.bitness.pricing.infrastructure.xchange

import event.TickerEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class TickerEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    fun publishCustomEvent(amount: Double) {
        println("Publishing custom event. ")
        val customSpringEvent = TickerEvent(amount)
        applicationEventPublisher.publishEvent(customSpringEvent)
    }
}
