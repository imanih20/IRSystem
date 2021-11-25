package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Folder
import models.Sentence
import theme.BNazanin
import theme.Helvetica
import utils.TextFormatter

//search bar in right for searching and showing results
@Composable
fun SearchView(modifier: Modifier = Modifier){
    val list = mutableListOf<Sentence>(
        Sentence(content = "تست",2,4),
        Sentence("تست",2,4),
        Sentence("تست",2,4)
    )
    Column(modifier) {
        TextFiled()
        ResultList(list)
    }
}


//list for displaying search result
@Composable
fun ResultList(results: List<Sentence>){
    LazyColumn (contentPadding = PaddingValues(7.dp),verticalArrangement = Arrangement.spacedBy(2.dp)){
        items(results){result->
            listItem(result,Modifier.fillMaxWidth().clickable {  })
        }
    }
}
//items for list
@Composable
@Preview
fun listItem(sentence: Sentence,modifier: Modifier = Modifier){
    Card (modifier,shape = RoundedCornerShape(15.dp)){
        Column (modifier = Modifier.padding(10.dp),verticalArrangement = Arrangement.spacedBy(5.dp)){
            Text(
                sentence.content,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    fontFamily = BNazanin
                )
            )
            Row {
                Text(
                    "فایل : ",
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = BNazanin
                    )
                )
                Text(
                    "${sentence.fileId}",
                    style = TextStyle(
                        color = Color.Black,
                        textDirection = TextDirection.Ltr,
                        fontSize = 19.sp,
                        fontFamily = Helvetica
                    )
                )
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    "خط ",
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = BNazanin
                    )
                )
                Text(
                    TextFormatter.toPersianNum(sentence.line.toString()),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = BNazanin
                    )
                )
            }
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