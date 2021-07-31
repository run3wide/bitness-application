package component

import api.BitnessApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.EventSource
import org.w3c.dom.MessageEvent
import react.*
import styled.styledDiv

interface TickerProps : RProps {
    var currencySymbol: String
}

val Ticker = fc<TickerProps> { props ->
    val (btcExchangeRate, setBtcExchangeRate) = useState<String?>(null)
    val eventSource = EventSource("http://localhost:8080/rest/exchange-rates/${props.currencySymbol}/stream")

    useEffect {
        GlobalScope.launch {
            setBtcExchangeRate(
                BitnessApi.getCurrentExchangeRateInUsd(props.currencySymbol).toString()
            )
        }
        eventSource.addEventListener(
            "${props.currencySymbol}_PRICE",
            { setBtcExchangeRate((it as MessageEvent).data.toString()) },
        )
        this.cleanup {
            eventSource.close()
        }
    }

    btcExchangeRate?.let {
        styledDiv {
            +"1 ${props.currencySymbol} = \$$it"
        }
    }
}
