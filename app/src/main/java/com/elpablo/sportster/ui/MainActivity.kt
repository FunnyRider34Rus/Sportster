package com.elpablo.sportster.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.elpablo.sportster.core.navigation.SetupNavGraph
import com.elpablo.sportster.core.theme.SportsterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            SportsterTheme {
                Sportster()
            }
        }
    }
}

@Composable
fun Sportster() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}