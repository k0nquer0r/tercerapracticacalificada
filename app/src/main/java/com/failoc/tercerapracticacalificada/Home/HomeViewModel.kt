package com.failoc.tercerapracticacalificada.Home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.failoc.tercerapracticacalificada.Model.Nota
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {

    private val repository = HomeRepository(application)

    //Listado
    val notes = repository.getNotes()

    //Registro

    fun saveNote(nota : Nota){
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(nota)
        }
    }

    // Actualizar
    fun updateNote(nota: Nota) {
        viewModelScope.launch {
            repository.updateNoteWithCoroutines(nota)
        }
    }

    // Eliminar
    fun deleteNote(nota: Nota) {
        viewModelScope.launch {
            repository.deleteNoteWithCoroutines(nota)
        }
    }
}