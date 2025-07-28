package com.sosauce.cutecalc.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sosauce.cutecalc.R
import com.sosauce.cutecalc.data.datastore.rememberShowOnLockScreen
import com.sosauce.cutecalc.ui.screens.settings.components.SettingsSwitch
import com.sosauce.cutecalc.ui.screens.settings.components.SettingsWithTitle
import com.sosauce.cutecalc.ui.shared_components.ScaffoldWithBackArrow

@Composable
fun SettingsMisc(
    onNavigateUp: () -> Unit
) {
    val scrollState = rememberScrollState()
    var showOnLockScreen by rememberShowOnLockScreen()

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
                title = R.string.misc
            ) {
                SettingsSwitch(
                    checked = showOnLockScreen,
                    onCheckedChange = { showOnLockScreen = !showOnLockScreen },
                    topDp = 24.dp,
                    bottomDp = 24.dp,
                    text = R.string.show_ls,
                    optionalDescription = R.string.show_ls_desc
                )
            }
        }
    }
}