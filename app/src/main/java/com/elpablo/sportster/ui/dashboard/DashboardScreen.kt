package com.elpablo.sportster.ui.dashboard

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.elpablo.sportster.R
import com.elpablo.sportster.core.theme.SportsterTheme
import com.elpablo.sportster.core.utils.AppConst
import com.elpablo.sportster.databinding.MapViewBinding
import com.elpablo.sportster.ui.dashboard.components.StortsterDashboardDisplayDataComponent
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.runtime.image.ImageProvider

@RequiresApi(Build.VERSION_CODES.P)
@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: DashboardViewState,
    onEvent: (DashboardEvent) -> Unit,
    navigateToPermissionScreen: () -> Unit
) {

    val context = LocalContext.current
    val activity = context as Activity
    val permissionsState = rememberMultiplePermissionsState(permissions = AppConst.permissions)
    val imageProvider = ImageProvider.fromResource(context, R.drawable.location_pin)

    LaunchedEffect(key1 = permissionsState.allPermissionsGranted) {
        if (!permissionsState.allPermissionsGranted) {
            navigateToPermissionScreen.invoke()
        }
        onEvent.invoke(DashboardEvent.Location(context))
    }

    Column(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(32.dp)) {
            Row {
                Text(
                    text = stringResource(id = R.string.dashboard_screen_greeting_text),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Normal)
                )
                Text(
                    text = state.user?.displayName
                        ?: stringResource(id = R.string.dashboard_screen_default_user_text),
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small)),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }

        StortsterDashboardDisplayDataComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            state = state
        )

        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            AndroidViewBinding(
                factory = MapViewBinding::inflate,
                modifier = Modifier
            ) {
                mapview.onStart()

                mapview.mapWindow.map.move(
                    CameraPosition(
                        Point(
                            state.location?.latitude ?: 0.0,
                            state.location?.longitude ?: 0.0
                        ),
                        /* zoom = */ 18.0f,
                        /* azimuth = */ 0.0f,
                        /* tilt = */ 60.0f
                    )
                )

                mapview.mapWindow.map.mapObjects.clear()

                mapview.mapWindow.map.mapObjects.addPlacemark().apply {
                    geometry = Point(
                        state.location?.latitude ?: 0.0,
                        state.location?.longitude ?: 0.0
                    )
                    setIcon(imageProvider)
                }
            }
            
            FloatingActionButton(
                onClick = { onEvent(DashboardEvent.TrainingStart(context)) },
                modifier = Modifier.padding(32.dp)
            ) {
                if (state.startTrainig) {
                    Icon(Icons.Filled.Close, "Training stop button.")
                } else {
                    Icon(Icons.Filled.PlayArrow, "Training start button.")
                }
            }
        }
    }
}

@SuppressLint("NewApi")
@Preview(showBackground = true, device = "id:pixel_5")
@Composable
private fun DashboardPreview() {
    SportsterTheme {
        DashboardScreen(
            state = DashboardViewState(),
            onEvent = { },
            navigateToPermissionScreen = { }
        )
    }
}