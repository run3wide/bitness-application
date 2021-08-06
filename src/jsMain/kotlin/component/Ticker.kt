package component

import api.BitnessApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.id
import org.w3c.dom.EventSource
import org.w3c.dom.MessageEvent
import org.w3c.dom.events.Event
import react.RProps
import react.dom.attrs
import react.dom.img
import react.fc
import react.useEffect
import react.useState
import styled.css
import styled.styledDiv

interface TickerProps : RProps {
    var currencySymbol: String
}

val Ticker = fc<TickerProps> { props ->
    val (exchangeRate, setExchangeRate) = useState<String?>(null)
    val eventSource = EventSource("http://localhost:8080/rest/exchange-rates/${props.currencySymbol}/stream")

    useEffect {
        GlobalScope.launch {
            val formattedExchangeRate = BitnessApi
                .getCurrentExchangeRateInUsd(props.currencySymbol)
                .format()
            setExchangeRate(formattedExchangeRate)
        }
        val callback: (Event) -> Unit = {
            val formattedExchangeRate = it.toExchangeRate().format()
            setExchangeRate(formattedExchangeRate)
        }
        val eventName = "${props.currencySymbol}_PRICE"
        eventSource.addEventListener(eventName, callback)
        this.cleanup { eventSource.close() }
    }

    exchangeRate?.let { exchangeRateInUsd ->
        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                alignItems = Align.center
                hover {
                    backgroundColor = Color.lightGray
                }
                paddingBottom = 2.rem
            }
            styledDiv {
                css {
                    float = Float.left
                    width = 75.pct
                }
                img(src = "https://images.run3wide.com/bitness/${props.currencySymbol.lowercase()}_logo.png") {
                    attrs {
                        height = "50px"
                    }
                }
            }
            styledDiv {
                attrs {
                    id = "exchangeRate_$exchangeRateInUsd"
                }
                css {
                    marginRight = 0.rem
                }
                +exchangeRateInUsd
            }
        }
    }
}

private fun Double.format(): String = this.asDynamic().toFixed(2) as String

private fun Event.toExchangeRate() = (this as MessageEvent)
    .data
    .toString()
    .toDouble()
