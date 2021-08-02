package component

import kotlinx.css.Display
import kotlinx.css.JustifyContent
import kotlinx.css.display
import kotlinx.css.justifyContent
import react.RProps
import react.fc
import styled.css
import styled.styledDiv

val WelcomePage = fc<RProps> {
    styledDiv {
        css {
            display = Display.flex
            justifyContent = JustifyContent.center
        }
        +"Welcome to Bitness!"
    }
}
