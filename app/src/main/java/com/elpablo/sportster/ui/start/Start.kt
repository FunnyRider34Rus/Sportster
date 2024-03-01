package com.elpablo.sportster.ui.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.R
import com.elpablo.sportster.core.components.SportsterButton
import com.elpablo.sportster.core.components.SportsterTitleOnlyText
import com.elpablo.sportster.core.theme.SportsterTheme

@Composable
fun StartScreen(modifier: Modifier = Modifier, navigateToNextScreen: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        SportsterTitleOnlyText(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.start_screen_title)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.start_screen_greeting),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        SportsterButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.start_screen_button),
            onClick = navigateToNextScreen
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun StartPreview() {
    SportsterTheme {
        StartScreen(modifier = Modifier) {

        }
    }
}