package com.sosauce.cutecalc.domain.repository

import com.sosauce.cutecalc.domain.model.Calculation

sealed interface HistoryEvents {

    data class DeleteCalculation(val calculation: Calculation) : HistoryEvents
    data object DeleteAllCalculation : HistoryEvents
    data class AddCalculation(
        val operation: String,
        val result: String,
        val maxHistoryItems: Long,
        val saveErrors: Boolean
    ) : HistoryEvents
}