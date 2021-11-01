package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//for showing content of each file in results
@Composable
fun ShowView(modifier: Modifier = Modifier){
    Box(modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Text("چیزی برای نمایش وجود ندارد.")
    }
}