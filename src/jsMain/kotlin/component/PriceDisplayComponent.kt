package component

import api.BitnessApi
import dto.pricing.ExchangeRateDto
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.*
import react.dom.div

val PriceDisplayComponent = functionalComponent<RProps> {

    val (btcExchangeRate, setBtcExchangeRate) = useState<ExchangeRateDto?>(null)

    useEffect(dependencies = listOf()) {
        MainScope().launch {
            val latestBtcExchangeRate = BitnessApi.getLatestBtcExchangeRate()
            setBtcExchangeRate(latestBtcExchangeRate)
        }
    }

    btcExchangeRate?.let {
        div {
            +"1 BTC = ${it.amount} ${it.currency}"
        }
    }
}
