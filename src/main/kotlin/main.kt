import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Folder

@Composable
@Preview
fun App() {
    MaterialTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
            Row(Modifier.fillMaxSize()) {
                SearchView(modifier = Modifier.fillMaxHeight().shadow(elevation = 5.dp).background(Color.LightGray).fillMaxWidth(0.33f))
                ShowView(modifier = Modifier.fillMaxSize().align(Alignment.CenterVertically))
            }
        }
    }
}

@Composable
fun SearchView(modifier: Modifier = Modifier){
    Column(modifier) {
        TextFiled()
        LazyColumn {

        }
    }
}
@Composable
fun ShowView(modifier: Modifier = Modifier){
    Box(modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Text("چیزی  برای نمایش وجود ندارد.")
    }
}
@Composable
fun TextFiled(modifier: Modifier = Modifier){
    var text by remember { mutableStateOf("") }

    Box (modifier = modifier.wrapContentSize().padding(10.dp),contentAlignment = Alignment.TopCenter){
        TextField(
            text,
            colors = TextFieldDefaults.textFieldColors(
              backgroundColor = Color.White,
              disabledIndicatorColor = Color.Transparent,
              unfocusedIndicatorColor = Color.Transparent,
              focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.border(1.dp,shape = RoundedCornerShape(15.dp),color = MaterialTheme.colors.primary),
            onValueChange = {
                text = it
            },
            trailingIcon = {
                Icon(Icons.Default.Search,contentDescription = null, modifier = Modifier.clickable {  })
            },
            leadingIcon = {
                Icon(CssGgIcons.Folder,contentDescription = null,modifier = Modifier.clickable {  })
            }
        )

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,resizable = false) {
        App()
    }
}
