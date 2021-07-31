package api

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

object BitnessApi {

    private const val API_URL = "http://localhost:8080"

    private val jsonClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getCurrentExchangeRateInUsd(currency: String): Double {
        return jsonClient.get("$API_URL/rest/exchange-rates/$currency")
    }
}
