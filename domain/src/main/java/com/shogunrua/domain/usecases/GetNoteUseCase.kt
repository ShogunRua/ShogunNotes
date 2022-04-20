package com.shogunrua.domain.usecases

import com.shogunrua.domain.model.Note
import com.shogunrua.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}
