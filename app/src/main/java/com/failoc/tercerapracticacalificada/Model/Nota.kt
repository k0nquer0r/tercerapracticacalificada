package com.failoc.tercerapracticacalificada.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Nota(
    @ColumnInfo(name = "title_note")
    val title: String,
    @ColumnInfo(name = "autor_note")
    val autor: String,
    @ColumnInfo(name = "category_note")
    val category: String,
    @ColumnInfo(name = "editorial_note")
    val editorial: String,
    @ColumnInfo(name = "description_note")
    val description: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var noteID: Int = 0
}