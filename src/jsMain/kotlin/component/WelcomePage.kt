package component

import configuration.ThemeConfiguration
import kotlinx.css.*
import react.RProps
import react.fc
import styled.css
import styled.styledDiv

val WelcomePage = fc<RProps> {
    styledDiv {
        css {
            display = Display.flex
            justifyContent = JustifyContent.center
            fontFamily = ThemeConfiguration.PRIMARY_FONT_FAMILY
            paddingTop = 4.rem
        }
        +"Welcome to Bitness!"
    }
}
