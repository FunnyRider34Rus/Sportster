package com.elpablo.sportster.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.elpablo.sportster.core.theme.SportsterTheme

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel
    ) {

    val test = remember {mutableStateOf("") }
    LaunchedEffect(key1 = viewModel.isUserAuthenticated) {
        test.value = viewModel.isUserAuthenticated.toString()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = test.value)
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    SportsterTheme {
        DashboardScreen(viewModel = hiltViewModel())
    }
}