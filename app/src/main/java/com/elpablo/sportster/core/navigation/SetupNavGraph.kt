package com.elpablo.sportster.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.elpablo.sportster.ui.dashboard.DashboardScreen
import com.elpablo.sportster.ui.dashboard.DashboardViewModel
import com.elpablo.sportster.ui.login.LoginScreen
import com.elpablo.sportster.ui.login.LoginViewModel
import com.elpablo.sportster.ui.permissions.PermissionsScreen
import com.elpablo.sportster.ui.start.StartScreen
import com.elpablo.sportster.ui.start.StartViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    Scaffold { paddingValue ->
        val modifier = Modifier.padding(paddingValue)
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = Screen.PERMISSIONS.route) {
                PermissionsScreen(
                    modifier = modifier,
                    navigateIfPermissionsGranted = { navController.navigate(Graph.MAIN.route) }
                )
            }
            composable(route = Screen.LOGIN.route) {
                val viewModel: LoginViewModel = hiltViewModel()
                LoginScreen(
                    modifier = modifier,
                    viewModel = viewModel,
                    signInClick = { viewModel.oneTapSignIn() },
                    navigateToMainScreen = {
                        navController.navigate(Graph.MAIN.route)
                    }
                )
            }
            navigation(startDestination = Screen.START.route, route = Graph.ONBOARD.route) {
                composable(route = Screen.START.route) {
                    val viewModel: StartViewModel = hiltViewModel()
                    StartScreen(
                        modifier = modifier,
                        navigateToNextScreen = {
                            viewModel.saveAppEntry()
                            navController.navigate(Screen.PERMISSIONS.route)
                        }
                    )
                }
            }
            navigation(startDestination = Screen.DASHBOARD.route, route = Graph.MAIN.route) {
                composable(route = Screen.DASHBOARD.route) {
                    val viewModel: DashboardViewModel = hiltViewModel()
                    DashboardScreen(
                        modifier = modifier,
                        viewModel = viewModel
                    )
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