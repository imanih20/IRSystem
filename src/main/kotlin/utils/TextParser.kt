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

fun main() {
    val content = ContentLouder("/home/mohyeddin/Documents/test/45.txt").getContent()
    val sent = TextParser.getSentences(content)
    for (line in sent){
        println(line)
    }
}