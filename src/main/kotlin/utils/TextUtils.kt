package utils

import database.DBSettings
import database.FileDao
import models.Sentence
import java.io.File
import java.util.*


object TextFormatter{
    fun toPersianNum(text: String) : String{
        val builder = StringBuilder()
        for (c in text){
            if (c.isDigit()){
                when(c){
                    '1' -> {builder.append('۱')}
                    '2' -> {builder.append('۲')}
                    '3' -> {builder.append('۳')}
                    '4' -> {builder.append('۴')}
                    '5' -> {builder.append('۵')}
                    '6' -> {builder.append('۶')}
                    '7' -> {builder.append('۷')}
                    '8' -> {builder.append('۸')}
                    '9' -> {builder.append('۹')}
                    '0' -> {builder.append('۰')}
                }
            }
        }
        return builder.toString()
    }

}

fun main() {
    DBSettings.db
    val file = File("assets/dataFiles/04_fa_0.txt");
    val contentLouder = ContentLouder(file)
    println(contentLouder.getSentences().size)
}