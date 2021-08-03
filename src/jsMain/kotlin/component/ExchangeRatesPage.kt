package component

import kotlinx.css.*
import react.RProps
import react.child
import react.fc
import styled.css
import styled.styledDiv

val ExchangeRatesPage = fc<RProps> {
    val currencies = listOf(
        "BTC",
        "LTC",
        "ETH",
    )

    styledDiv {
        css {
            display = Display.flex
            justifyContent = JustifyContent.center
            alignItems = Align.center
            backgroundColor = Color.grey
        }
        currencies.forEach { currency ->
            child(Ticker) {
                attrs {
                    currencySymbol = currency
                }
            }
        }
    }
}
