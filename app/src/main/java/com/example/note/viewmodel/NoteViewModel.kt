package com.example.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.model.NoteData
import com.example.note.model.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    fun getAllNote() : LiveData<List<NoteData>> = repository.noteData()

    fun search(text : String) : LiveData<List<NoteData>> = repository.search(text)

    fun insert(noteData: NoteData){
        viewModelScope.launch {Dispatchers.IO
            repository.insert(noteData)
        }
    }

    fun update(noteData : NoteData){
        viewModelScope.launch {Dispatchers.IO
        repository.update(noteData)
        }
    }

    fun delete(id : Int){
        viewModelScope.launch { Dispatchers.IO
        repository.delete(id)
        }
    }

}