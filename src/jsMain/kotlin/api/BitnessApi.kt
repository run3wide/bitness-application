package api

import dto.pricing.PriceDto
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

object BitnessApi {

    private const val endpoint =
        "http://localhost:8080" // only needed until https://github.com/ktorio/ktor/issues/1695 is resolved

    private val jsonClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getPrices(): List<PriceDto> {
        return jsonClient.get("$endpoint/rest/prices")
    }
}
