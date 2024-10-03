package com.quietcolossus.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}