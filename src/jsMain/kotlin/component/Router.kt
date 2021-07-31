package component

import react.RProps
import react.child
import react.fc
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import styled.styledDiv

val AppRouter = fc<RProps> {
    styledDiv {
        browserRouter {
            child(NavBar)
            switch {
                route("/", exact = true) { child(WelcomePage) }
                route("/exchange-rates", exact = true) { child(ExchangeRatesPage) }
            }
        }
    }
}
