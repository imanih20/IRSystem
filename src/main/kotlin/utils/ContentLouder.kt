package utils

import java.io.*
import java.lang.StringBuilder


class ContentLouder(path: String) {
    private val file: File = File(path)

    fun getContent() : String{
        val reader = BufferedReader(InputStreamReader(FileInputStream(file),"utf-8"))
        val builder = StringBuilder()
        var line = reader.readLine()
        while (line!=null){
            builder.append(line).append("\n");
            line = reader.readLine()
        }
        return builder.toString()
    }
}