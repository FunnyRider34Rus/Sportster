package com.elpablo.sportster.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.elpablo.sportster.ui.theme.SportsterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SportsterTheme {
        Sportster()
    }
}