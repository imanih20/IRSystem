package database

import org.jetbrains.exposed.dao.id.IntIdTable

object SentenceTable : IntIdTable("sentence"){
    val content = varchar("content",3000)
    val fileId = integer("fileId").references(FileTable.id)
    val line = integer("line")
}
object FileTable : IntIdTable("file"){
    val path = varchar("path",500)
    val name = varchar("name",100)
}