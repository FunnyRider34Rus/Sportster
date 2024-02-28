package com.elpablo.sportster.ui.screens.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elpablo.sportster.ui.theme.SportsterTheme

@Composable
fun StartScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "StartScreen")
    }
}

@Preview(showBackground = true)
@Composable
fun StartPreview() {
    SportsterTheme {
        StartScreen()
    }
}