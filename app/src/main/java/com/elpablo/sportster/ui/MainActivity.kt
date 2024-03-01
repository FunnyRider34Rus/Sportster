package com.elpablo.sportster.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.elpablo.sportster.core.navigation.Graph
import com.elpablo.sportster.core.navigation.Screen
import com.elpablo.sportster.core.navigation.SetupNavGraph
import com.elpablo.sportster.core.theme.SportsterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.splashState
        }

        enableEdgeToEdge()

        setContent {
            SportsterTheme {
                Sportster(startDestination = viewModel.startDestination)
            }
        }
    }
}

@Composable
fun Sportster(startDestination: String) {
    val navController = rememberNavController()
    SetupNavGraph(
        navController = navController,
        startDestination = Graph.MAIN.route//startDestination
    )
}