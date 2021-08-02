package component

import api.BitnessApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import org.w3c.dom.EventSource
import org.w3c.dom.MessageEvent
import react.*
import react.dom.attrs
import react.dom.img
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
            setExchangeRate(
                BitnessApi.getCurrentExchangeRateInUsd(props.currencySymbol).format()
            )
        }
        eventSource.addEventListener(
            "${props.currencySymbol}_PRICE",
            {
                val data = (it as MessageEvent).data.toString().toDouble()
                setExchangeRate(data.format())
            },
        )
        this.cleanup {
            eventSource.close()
        }
    }

    exchangeRate?.let { exchangeRateInUsd ->
        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                justifyContent = JustifyContent.center
                alignItems = Align.center
            }
            img(src = "https://images.run3wide.com/bitness/${props.currencySymbol.lowercase()}_logo.png") {
                attrs {
                    height = "50px"
                }
            }
            +exchangeRateInUsd
        }
    }
}

private fun Double.format(): String = this.asDynamic().toFixed(2) as String
