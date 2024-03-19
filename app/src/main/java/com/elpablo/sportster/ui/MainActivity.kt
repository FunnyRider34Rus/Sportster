package com.elpablo.sportster.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.elpablo.sportster.core.navigation.SetupNavGraph
import com.elpablo.sportster.core.theme.SportsterTheme
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        enableEdgeToEdge()

        setContent {
            SportsterTheme {
                Sportster(startDestination = viewModel.startDestination.value)
            }
        }
    }


    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun Sportster(startDestination: String) {
    val navController = rememberNavController()
    SetupNavGraph(
        navController = navController,
        startDestination = startDestination
    )
}