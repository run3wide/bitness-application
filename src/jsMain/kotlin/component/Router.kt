package component

import kotlinx.css.pct
import kotlinx.css.width
import react.RProps
import react.child
import react.fc
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import styled.css
import styled.styledDiv

val AppRouter = fc<RProps> {
    styledDiv {
        css {
            width = 100.pct
        }
        browserRouter {
            child(NavBar)
            switch {
                route("/", exact = true) { child(WelcomePage) }
                route("/exchange-rates", exact = true) { child(ExchangeRatesPage) }
            }
        }
    }
}
