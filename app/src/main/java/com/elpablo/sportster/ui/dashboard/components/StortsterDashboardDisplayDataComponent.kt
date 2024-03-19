package com.elpablo.sportster.ui.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.core.theme.SportsterTheme
import com.elpablo.sportster.ui.dashboard.DashboardViewState

@Composable
fun StortsterDashboardDisplayDataComponent(
    modifier: Modifier = Modifier,
    state: DashboardViewState = DashboardViewState()
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "00:00:00",
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.displayLarge
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "${state.location?.latitude.toString()}",
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${state.location?.longitude.toString()}",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.bodyLarge
            )
//            Text(
//                text = "8,43",
//                color = MaterialTheme.colorScheme.primary,
//                style = MaterialTheme.typography.bodyLarge
//            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "latitude",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "longitude",
                style = MaterialTheme.typography.bodyLarge
            )
//            Text(
//                text = "темп",
//                style = MaterialTheme.typography.bodyLarge
//            )
        }
    }
}

@Preview
@Composable
private fun StortsterDashboardDisplayDataComponentPreview() {
    SportsterTheme {
        StortsterDashboardDisplayDataComponent()
    }
}