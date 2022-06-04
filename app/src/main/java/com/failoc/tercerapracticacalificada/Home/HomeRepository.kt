package com.failoc.tercerapracticacalificada.Home

import android.app.Application
import androidx.lifecycle.LiveData
import com.failoc.tercerapracticacalificada.DataBase.MunicipalidadDataBase
import com.failoc.tercerapracticacalificada.Model.Dao.NotaDao
import com.failoc.tercerapracticacalificada.Model.Nota
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(application: Application) {

    private val noteDao: NotaDao?= MunicipalidadDataBase.getInstance(application)?.noteDao()

    fun getNotes(): LiveData<List<Nota>> {
        return noteDao?.getListNote()!!
    }

    suspend fun insertNoteWithCoroutines(note: Nota){
        processInsertNote(note)
    }

    private suspend fun processInsertNote(note: Nota){
        withContext(Dispatchers.Default){
            noteDao?.insert(note)
        }
    }

    //Actualizar

    suspend fun updateNoteWithCoroutines(nota: Nota) {
        processUpdateNote(nota)
    }

    private suspend fun processUpdateNote(nota: Nota) {
        withContext(Dispatchers.Default) {
            noteDao?.update(nota)
        }
    }


    //Eliminar

    suspend fun deleteNoteWithCoroutines(nota: Nota){
        processDeleteNote(nota)
    }

    private suspend fun processDeleteNote(nota: Nota){
        withContext(Dispatchers.Default){
            noteDao?.delete(nota)
        }
    }
}