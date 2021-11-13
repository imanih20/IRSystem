package database

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DBSettings {
    val db by lazy{
        Database.connect("jdbc:sqlite:./database.db","org.sqlite.JDBC")
    }
    fun createTable(){
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(SentenceTable,FileTable,FileSentenceTable)
        }
    }
}