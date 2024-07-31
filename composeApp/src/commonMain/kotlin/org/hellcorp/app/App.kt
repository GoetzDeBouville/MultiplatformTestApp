package org.hellcorp.app

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.hellcorp.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    MultiPlatformTestApp()
}

@Composable
internal fun MultiPlatformTestApp(
    navCotroller : NavHostController = rememberNavController()
){

}

internal expect fun openUrl(url: String?)