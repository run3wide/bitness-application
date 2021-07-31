import component.AppRouter
import kotlinx.browser.document
import react.child
import react.dom.render
import styled.styledDiv

fun main() {
    render(document.getElementById("root")) {
        styledDiv {
            child(AppRouter)
        }
    }
}
