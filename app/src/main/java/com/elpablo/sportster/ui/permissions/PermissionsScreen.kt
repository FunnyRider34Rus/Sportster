@file:OptIn(ExperimentalPermissionsApi::class)

package com.elpablo.sportster.ui.permissions

import android.app.Activity
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.R
import com.elpablo.sportster.core.components.SportsterButton
import com.elpablo.sportster.core.components.SportsterTitleOnlyText
import com.elpablo.sportster.core.theme.SportsterTheme
import com.elpablo.sportster.core.utils.AppConst.permissions
import com.elpablo.sportster.core.utils.openAppSettings
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@Composable
fun PermissionsScreen(
    modifier: Modifier = Modifier,
    navigateIfPermissionsGranted: () -> Unit
) {

    val context = LocalContext.current as Activity
    val permissionsState = rememberMultiplePermissionsState(permissions = permissions)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        SportsterTitleOnlyText(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.permissions_screen_title)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (!permissionsState.allPermissionsGranted) {
            if (!permissionsState.shouldShowRationale){
                Text(
                    text = stringResource(id = R.string.permissions_screen_body),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(id = R.string.permissions_screen_description),
                    modifier = Modifier.padding(top = 16.dp),
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.weight(1f))
                SportsterButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.permissions_screen_button_open_permission_dialog),
                    onClick = { permissionsState.launchMultiplePermissionRequest() }
                )
            } else {
                Text(
                    text = stringResource(id = R.string.permissions_screen_should_show_rationale),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                SportsterButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 32.dp),
                    text = stringResource(id = R.string.permissions_screen_button_open_system_settings),
                    onClick = {
                        context.openAppSettings()
                    }
                )
            }
        } else {
            navigateIfPermissionsGranted.invoke()
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewPermissionsScreen() {
    SportsterTheme {
        PermissionsScreen(
            navigateIfPermissionsGranted = { })
    }
}