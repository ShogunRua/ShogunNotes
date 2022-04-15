package com.shogunrua.shogunnotesapp.notes

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
    object SaveNote : UiEvent()
}
