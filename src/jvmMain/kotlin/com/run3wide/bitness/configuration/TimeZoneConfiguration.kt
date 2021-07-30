package com.run3wide.bitness.configuration

import java.util.TimeZone
import javax.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class TimeZoneConfiguration {

    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }
}
