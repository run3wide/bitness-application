package component

import kotlinx.css.JustifyContent
import kotlinx.css.justifyContent
import react.RProps
import react.fc
import styled.css
import styled.styledDiv

val WelcomePage = fc<RProps> {
    styledDiv {
        css {
            justifyContent = JustifyContent.center
        }
        +"Welcome to Bitness!"
    }
}
