package component

import configuration.ThemeConfiguration
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.UL
import react.RProps
import react.dom.attrs
import react.dom.img
import react.fc
import react.router.dom.routeLink
import styled.*

val NavBar = fc<RProps> {
    styledDiv {
        css {
            display = Display.flex
            backgroundColor = ThemeConfiguration.PRIMARY_COLOR
            justifyItems = JustifyItems.center
        }
        styledDiv {
            css {
                display = Display.flex
                gap = 4.rem
                alignItems = Align.center
                paddingLeft = 3.rem
            }

            img(src = "https://images.run3wide.com/bitness/bitness_logo.png") {
                attrs {
                    height = 25.rem.toString()
                }
            }
            styledUl {
                css {
                    display = Display.inlineFlex
                    gap = 1.5.rem
                    listStyleType = ListStyleType.none
                    justifyContent = JustifyContent.spaceBetween
                }
                navBarLink("/", "Home")
                navBarLink("/exchange-rates", "Rates")
            }
        }
    }
}

private fun StyledDOMBuilder<UL>.navBarLink(location: String, displayText: String) {
    routeLink(to = location) {
        styledP {
            css {
                fontFamily = "Arial"
                fontSize = 0.8.rem
                color = Color.white
                textDecoration = TextDecoration.none
            }
            +displayText
        }
    }
}
