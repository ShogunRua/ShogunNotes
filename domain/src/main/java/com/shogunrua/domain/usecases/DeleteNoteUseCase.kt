package com.shogunrua.domain.usecases

import com.shogunrua.domain.model.Note
import com.shogunrua.domain.repository.NoteRepository

class DeleteNoteUseCase(
   private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}
