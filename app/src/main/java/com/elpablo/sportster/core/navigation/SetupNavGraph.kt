package com.elpablo.sportster.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elpablo.sportster.ui.screens.dashboard.DashboardScreen
import com.elpablo.sportster.ui.screens.start.StartScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.START.route) {
            StartScreen()
        }
        composable(route = Screen.DASHBOARD.route) {
            DashboardScreen()
        }
    }
}