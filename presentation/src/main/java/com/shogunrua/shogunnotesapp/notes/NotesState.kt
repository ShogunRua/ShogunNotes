package com.shogunrua.shogunnotesapp.notes

import com.shogunrua.domain.model.Note
import com.shogunrua.domain.util.NoteOrder
import com.shogunrua.domain.util.OrderType
import com.shogunrua.shogunnotesapp.ui.theme.*

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

