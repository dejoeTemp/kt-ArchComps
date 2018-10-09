package wards.jungle.archcomps

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note (@PrimaryKey(autoGenerate = true) var id:Int,
                 @ColumnInfo(name="title") var title:String,
                 @ColumnInfo(name="description") var description: String,
                 @ColumnInfo(name="priority") var priority: Int) {
    constructor(title: String, description: String, priority: Int)
            :this(-1, title, description,priority)

}