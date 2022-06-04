package com.failoc.tercerapracticacalificada.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.failoc.tercerapracticacalificada.Model.Nota

@Dao
interface NotaDao {
    @Insert
    fun insert(nota: Nota)
    @Update
    fun update(nota: Nota)
    @Delete
    fun delete(nota: Nota)

    @Query("SELECT * FROM note_table ORDER BY note_id DESC")
    fun getListNote(): LiveData<List<Nota>>
    @Query("UPDATE note_table SET title_note=:title, autor_note=:autor, category_note=:category, editorial_note=:editorial ,description_note=:description WHERE note_id=:id")
    fun update(title: String, autor: String, category: String, editorial: String, description: String, id: Int)

}