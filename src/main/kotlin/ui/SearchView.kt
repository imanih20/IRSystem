package ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Folder
import theme.Helvetica
import javax.swing.plaf.basic.BasicBorders

//search bar in right for searching and showing results
@Composable
fun SearchView(modifier: Modifier = Modifier){
    Column(modifier) {
        TextFiled()
        LazyColumn {

        }
    }
}

//a text field for getting input for search
@Composable
fun TextFiled(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Box(modifier = modifier.wrapContentSize().padding(10.dp), contentAlignment = Alignment.TopCenter) {
        TextField(
            text,
            textStyle = TextStyle(textAlign = TextAlign.Start,textDirection = TextDirection.Ltr,fontFamily = Helvetica,fontSize = 20.sp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.fillMaxWidth()
                .border(1.dp, shape = RoundedCornerShape(15.dp), color = MaterialTheme.colors.primary),
            onValueChange = {
                text = it
            },
            trailingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.clickable { })
            },
            leadingIcon = {
                Icon(CssGgIcons.Folder, contentDescription = null, modifier = Modifier.clickable { })
            }
        )
    }

}