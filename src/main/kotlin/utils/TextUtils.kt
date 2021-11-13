package utils

object TextParser {

    fun getSentences(content: String): List<String>{
        var i = 0
        val list = arrayListOf<String>()

        val chars = content.chars().toArray()
        val builder = StringBuilder()
        while (i<chars.size){
            val c = chars[i].toChar()
            if ((c == '.' && chars[i+1].toChar() != '.' && chars[i-1].toChar() != '.') || c =='؟' || c == '!'){
                list.add(builder.toString())
                builder.clear()
            } else {
                builder.append(c)
            }
            i++
        }
        return list
    }
}

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
    val content = ContentLouder("/home/mohyeddin/Documents/test/45.txt").getContent()
    val sent = TextParser.getSentences(content)
    for (line in sent){
        println(line)
    }
}