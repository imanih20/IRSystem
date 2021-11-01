package theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
//font families

val BNazanin = FontFamily(
    Font("BNazanin.ttf")
)
val Helvetica = FontFamily(
    Font("Helvetica.ttf", FontWeight.Normal),
    Font("Helvetica-Bold.ttf",FontWeight.Bold)
)

//typographies
val TypoGraphy = Typography(BNazanin)