package component

import configuration.ThemeConfiguration.PRIMARY_FONT_COLOR
import configuration.ThemeConfiguration.PRIMARY_FONT_FAMILY
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
        styledDiv {
            css {
                paddingTop = 1.5.rem
                paddingLeft = 3.rem
                fontSize = 1.rem
                color = PRIMARY_FONT_COLOR
                fontFamily = PRIMARY_FONT_FAMILY
            }
            +"Exchange Rates"
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
