package component

import kotlinx.css.*
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
            alignItems = Align.center
            justifyContent = JustifyContent.center
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
