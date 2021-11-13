package database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object SentenceTable : IntIdTable("sentence"){
    val content = varchar("content",500)
}
object FileTable : IntIdTable("file"){
    val path = varchar("path",500)
}
object FileSentenceTable : Table("file_sentence"){
    val file = integer("file_id").foreignKey
    val sentence = integer("sentence_id").references(SentenceTable.id)
    val line = integer("line").references(FileTable.id)
}