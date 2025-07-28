package com.sosauce.cutecalc.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.sosauce.cutecalc.R
import com.sosauce.cutecalc.data.datastore.rememberHistoryMaxItems
import com.sosauce.cutecalc.data.datastore.rememberSaveErrorsToHistory
import com.sosauce.cutecalc.data.datastore.rememberUseHistory
import com.sosauce.cutecalc.ui.screens.settings.components.SettingsDropdownMenu
import com.sosauce.cutecalc.ui.screens.settings.components.SettingsSwitch
import com.sosauce.cutecalc.ui.screens.settings.components.SettingsWithTitle
import com.sosauce.cutecalc.ui.shared_components.CuteDropdownMenuItem
import com.sosauce.cutecalc.ui.shared_components.CuteText
import com.sosauce.cutecalc.ui.shared_components.ScaffoldWithBackArrow

@Composable
fun SettingsHistory(
    onNavigateUp: () -> Unit,
) {

    val scrollState = rememberScrollState()
    var useHistory by rememberUseHistory()
    var historyMaxItems by rememberHistoryMaxItems()
    var saveErrorsToHistory by rememberSaveErrorsToHistory()
    val historyItemsChoice = listOf(
        10,
        20,
        50,
        100,
        200,
        500,
        1000,
        10000,
        Long.MAX_VALUE
    )


    ScaffoldWithBackArrow(
        backArrowVisible = !scrollState.canScrollBackward,
        onNavigateUp = onNavigateUp
    ) { pv ->

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(pv)
        ) {
            SettingsWithTitle(
                title = R.string.history
            ) {
                SettingsSwitch(
                    checked = useHistory,
                    onCheckedChange = { useHistory = !useHistory },
                    topDp = 24.dp,
                    bottomDp = 4.dp,
                    text = R.string.enable_history
                )
                SettingsSwitch(
                    checked = saveErrorsToHistory,
                    onCheckedChange = { saveErrorsToHistory = !saveErrorsToHistory },
                    topDp = 4.dp,
                    bottomDp = 4.dp,
                    text = R.string.save_errors
                )
                SettingsDropdownMenu(
                    value = historyMaxItems,
                    topDp = 4.dp,
                    bottomDp = 24.dp,
                    text = R.string.max_history_items
                ) {
                    historyItemsChoice.fastForEach {
                        CuteDropdownMenuItem(
                            onClick = { historyMaxItems = it },
                            text = { CuteText(if (it == Long.MAX_VALUE) stringResource(R.string.no_limit) else it.toString()) },
                            leadingIcon = {
                                RadioButton(
                                    selected = historyMaxItems == it,
                                    onClick = null
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}