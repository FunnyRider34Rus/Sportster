package com.elpablo.sportster.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.elpablo.sportster.ui.dashboard.DashboardScreen
import com.elpablo.sportster.ui.permissions.PermissionsScreen
import com.elpablo.sportster.ui.start.StartScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    Scaffold { paddingValue ->
        val modifier = Modifier.padding(paddingValue)
        NavHost(
            navController = navController,
            startDestination = Graph.ONBOARD.route
        ) {
            navigation(startDestination = Screen.START.route, route = Graph.ONBOARD.route) {
                composable(route = Screen.START.route) {
                    StartScreen(
                        modifier = modifier,
                        navigateToNextScreen = { navController.navigate(Screen.PERMISSIONS.route) }
                    )
                }
                composable(route = Screen.PERMISSIONS.route) {
                    PermissionsScreen(
                        modifier = modifier,
                        navigateToPreviousScreen = { navController.navigate(Screen.START.route) },
                        navigateToNextScreen = { /*TODO*/ },
                        grantPermissions = { /*TODO*/ }
                    )
                }
            }
            navigation(startDestination = Screen.DASHBOARD.route, route = Graph.MAIN.route) {
                composable(route = Screen.DASHBOARD.route) {
                    DashboardScreen()
                }
            }
        }
    }
}

//navController.navigate(route = Graph.MAIN.route) {
//    popUpTo(Graph.ONBOARD.route) {
//        inclusive = true
//    }
//}