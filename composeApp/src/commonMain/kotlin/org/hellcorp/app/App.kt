package org.hellcorp.app

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.hellcorp.app.features.createpost.CreatePostScreen
import org.hellcorp.app.features.details.DetailsScreen
import org.hellcorp.app.features.feed.FeedScreen
import org.hellcorp.app.features.login.LoginScreen
import org.hellcorp.app.features.paywall.PaywallScreen
import org.hellcorp.app.navigation.AppScreens
import org.hellcorp.app.navigation.LocalNavHost
import org.hellcorp.app.navigation.main.MainScreen
import org.hellcorp.app.theme.AppTheme
import androidx.navigation.NavHostController as NavHostController

@Composable
internal fun App() = AppTheme {
    MultiPlatformTestApp()
}

@Composable
internal fun MultiPlatformTestApp(
    navCotroller : NavHostController = rememberNavController()
){
    val backStackEntry by navCotroller.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login

    CompositionLocalProvider(
        LocalNavHost provides navCotroller
    ) {
        NavHost(
            navController = navCotroller,
            startDestination = AppScreens.Login.title
        ) {
            composable(route = AppScreens.Login.title) {
                LoginScreen()
            }
            composable(route = AppScreens.Main.title) {
                MainScreen()
            }
            composable(route = AppScreens.Paywall.title) {
                PaywallScreen()
            }
            composable(route = AppScreens.CreatePost.title) {
                CreatePostScreen()
            }
        }
    }
}

internal expect fun openUrl(url: String?)