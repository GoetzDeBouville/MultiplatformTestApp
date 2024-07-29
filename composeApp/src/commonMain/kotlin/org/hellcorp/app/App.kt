package org.hellcorp.app

import androidx.compose.runtime.*
import org.hellcorp.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    
}

internal expect fun openUrl(url: String?)