package component

import configuration.ThemeConfiguration
import kotlinx.css.*
import react.RProps
import react.fc
import react.router.dom.routeLink
import styled.css
import styled.styledDiv

val NavBar = fc<RProps> {
    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            justifyContent = JustifyContent.spaceEvenly
            backgroundColor = ThemeConfiguration.PRIMARY_COLOR
        }
        routeLink(to = "/") { +"Home" }
        routeLink(to = "/exchange-rates") { +"Rates" }
    }
}
