package com.shogunrua.domain.usecases

import com.shogunrua.domain.exeptions.InvalidNoteException
import com.shogunrua.domain.model.Note
import com.shogunrua.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Заголовок заметки не может быть пустым.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Содержимое заметки не может быть пустое.")
        }
        repository.insertNote(note)
    }
}
