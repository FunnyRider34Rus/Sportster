package com.elpablo.sportster.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.elpablo.sportster.core.navigation.SetupNavGraph
import com.elpablo.sportster.ui.theme.SportsterTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }

        enableEdgeToEdge()
        setContent {
            SportsterTheme {
                Sportster(splashViewModel)
            }
        }
    }
}

@Composable
fun Sportster(viewModel: SplashScreenViewModel) {
    val screen by viewModel.startDestination
    val navController = rememberNavController()
    SetupNavGraph(navController = navController, startDestination = screen)
}