package com.elpablo.sportster.ui.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.core.theme.SportsterTheme

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: DashboardViewState
    ) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
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
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Оповещения",
                modifier = Modifier.size(32.dp).clickable {  },
                tint = MaterialTheme.colorScheme.primary
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    SportsterTheme {
        DashboardScreen(state = DashboardViewState())
    }
}