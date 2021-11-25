package models

import org.jetbrains.exposed.sql.AutoIncColumnType
import kotlin.properties.Delegates

data class FileModel(var id : Int = -1,val path: String, val name: String){
}