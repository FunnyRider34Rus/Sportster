package com.elpablo.sportster.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.R
import com.elpablo.sportster.core.components.SportsterButton
import com.elpablo.sportster.core.components.SportsterTitleOnlyText
import com.elpablo.sportster.core.theme.SportsterTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToNextScreen: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        SportsterTitleOnlyText(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.login_screen_title)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.login_screen_body),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = navigateToNextScreen,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(id = R.string.login_screen_button_login),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.titleSmall
            )
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun LoginScreenPreview() {
    SportsterTheme {
        LoginScreen {

        }
    }
}