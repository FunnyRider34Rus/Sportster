package com.elpablo.sportster.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.core.theme.SportsterTheme
import com.elpablo.sportster.core.utils.AppConst
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: DashboardViewState,
    navigateToPermissionScreen: () -> Unit,
    navigateToLoginScreen: () -> Unit
) {

    val permissionsState = rememberMultiplePermissionsState(permissions = AppConst.permissions)

    LaunchedEffect(key1 = permissionsState.allPermissionsGranted) {
        if (!permissionsState.allPermissionsGranted) {
            navigateToPermissionScreen.invoke()
        }
        if (!state.isUserLogged) {
            navigateToLoginScreen.invoke()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {

        Row {
            Text(
                text = "Привет,",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Normal)
            )
            Text(
                text = state.user?.displayName ?: "Пользователь",
                modifier = Modifier.padding(start = 8.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.primary
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun DashboardPreview() {
    SportsterTheme {
        DashboardScreen(
            state = DashboardViewState(),
            navigateToPermissionScreen = {  },
            navigateToLoginScreen = {  }
        )
    }
}