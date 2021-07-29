package component

import api.BitnessApi
import dto.pricing.PriceDto
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.*
import react.dom.div

val PriceDisplayComponent = functionalComponent<RProps> {

    val (prices, setPrices) = useState(emptyList<PriceDto>())

    useEffect(dependencies = listOf()) {
        MainScope().launch {
            val updatedPrices = BitnessApi.getPrices()
            updatedPrices.forEach { console.log(it.amount) }
            setPrices(updatedPrices)
        }
    }

    prices.forEach {
        div {
            +"1 BTC = ${it.amount} ${it.currency}"
        }
    }
}

