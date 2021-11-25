package database

import models.FileModel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import utils.ContentLouder

object FileDao {
    fun insert(fileModel: FileModel){
        transaction {
            FileTable.insert {
                it[path] = fileModel.path
                it[name] = fileModel.name
            }
        }
    }
    fun selectAll(): ArrayList<FileModel>{
        val list = arrayListOf<FileModel>()
        transaction {
            FileTable.selectAll().forEach {
                val file = FileModel(id = it[FileTable.id].value,path = it[FileTable.path],name = it[FileTable.name])
                list.add(file)
            }
        }
        return list
    }

    fun getFileId(path: String) : Int{
        var id = -1
        transaction {
            FileTable.select {
                FileTable.path  eq  path
            }.limit(1).forEach{
                id = it[FileTable.id].value
            }
        }
        return id
    }
    fun importFiles(path: String){
        val contentLouder = ContentLouder(path)
        val files = contentLouder.getSubTextFiles()
        println(files.size)
        transaction {
            for (file in files){
                insert(FileModel(path = file.absolutePath, name = file.name))
                SentenceDao.importSentences(file)
            }
        }
    }
}