package com.quietcolossus.auth.presentation.login

import com.quietcolossus.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}