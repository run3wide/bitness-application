package component

import react.RProps
import react.child
import react.fc
import styled.styledDiv

val ExchangeRatesPage = fc<RProps> {
    val currencies = listOf(
        "BTC",
        "LTC",
        "ETH",
    )

    styledDiv {
        currencies.forEach { currency ->
            child(Ticker) {
                attrs {
                    currencySymbol = currency
                }
            }
        }
    }
}
