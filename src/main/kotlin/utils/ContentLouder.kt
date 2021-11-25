package utils

import database.FileDao
import models.Sentence
import java.io.*

class ContentLouder(private val file: File) {
    constructor(path: String) : this(File(path))

    fun getSentences() : ArrayList<Sentence>{
        val list = arrayListOf<Sentence>()
        if (!file.isFile){
            return list
        }
        val reader = BufferedReader(InputStreamReader(FileInputStream(file),"utf-8"))
        var line = reader.readLine()
        var lineNum = 1
        val sentence = StringBuilder()
        while (line!=null){
            var i = 0
            val chars = line.chars().toArray()
            while (i<chars.size){
                val c = chars[i].toChar()
                if ((i+1!=chars.size && i!=0 && c == '.') && (c == '.' && chars[i+1].toChar() != '.' && chars[i-1].toChar() != '.') || c =='؟' || c == '!'){
                    list.add(Sentence(content = sentence.toString(), fileId = FileDao.getFileId(file.absolutePath),lineNum))
                    sentence.clear()
                } else {
                    sentence.append(c)
                }
                i++
            }
            line = reader.readLine()
            lineNum++
        }
        return list
    }
    fun getSubTextFiles() : ArrayList<File>{
        val fileList = arrayListOf<File>()
        if (!file.isDirectory){
            return fileList
        }
        val subFiles = file.listFiles()!!
        for (f in subFiles){
            if (!f.exists() || !f.isFile || f.extension!="txt"){
                continue
            }else{
                fileList.add(f)
                println(f.name)
            }
        }
        return fileList
    }


}