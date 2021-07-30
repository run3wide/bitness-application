package com.run3wide.bitness

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class BitnessApplication

fun main() {
    runApplication<BitnessApplication>()
}
