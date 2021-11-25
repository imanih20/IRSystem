package database

import androidx.compose.material.contentColorFor
import models.Sentence
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import utils.ContentLouder
import java.io.File

object SentenceDao {
    fun getSentences() : ArrayList<Sentence>{
        val list = arrayListOf<Sentence>()
        transaction {
            SentenceTable.selectAll().forEach{
                list.add(Sentence(it[SentenceTable.content],it[SentenceTable.fileId],it[SentenceTable.line]))
            }
        }
        return list
    }
    fun findSentence(content: String): ArrayList<Sentence> {
        val list = arrayListOf<Sentence>()
        transaction {
            SentenceTable.select {
                SentenceTable.content eq content
            }.forEach{
                list.add(Sentence(it[SentenceTable.content],it[SentenceTable.fileId],it[SentenceTable.line]))
            }
        }
        return list
    }
    fun insert(sentence: Sentence){
        transaction {
            SentenceTable.insert {
                it[content] = sentence.content
                it[fileId] = sentence.fileId
                it[line] = sentence.line
            }
        }
    }
    fun importSentences(file: File){
        val content = ContentLouder(file)
        val sentences = content.getSentences()
        transaction {
            for (sentence in sentences){
                insert(sentence)
            }
        }
    }
}