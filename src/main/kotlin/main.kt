import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import theme.TypoGraphy
import ui.SearchView
import ui.ShowView


fun main() = application {
    Window(onCloseRequest = ::exitApplication,resizable = true) {
        App()
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme(
        typography = TypoGraphy
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
            Row(Modifier.fillMaxSize()) {
                SearchView(modifier = Modifier.fillMaxHeight().shadow(elevation = 5.dp).background(Color.LightGray).fillMaxWidth(0.33f))
                ShowView(modifier = Modifier.fillMaxSize().align(Alignment.CenterVertically))
            }
        }
    }
}