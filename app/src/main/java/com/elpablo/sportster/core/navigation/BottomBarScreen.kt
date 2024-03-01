package com.elpablo.sportster.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.elpablo.sportster.R

sealed class BottomBarScreen(
    val route: String,
    @StringRes val lable: Int,
    val icon: ImageVector
) {
    data object Dashboard : BottomBarScreen(
        route = Screen.DASHBOARD.route,
        lable = R.string.bottombar_lable_dashboard,
        icon = Icons.AutoMirrored.Filled.DirectionsRun
    )

    data object Analytics : BottomBarScreen(
        route = Screen.ANALYTICS.route,
        lable = R.string.bottombar_label_analytics,
        icon = Icons.Filled.Analytics
    )

    data object Profile : BottomBarScreen(
        route = Screen.PROFILE.route,
        lable = R.string.bottombar_label_profile,
        icon = Icons.Filled.Person
    )
}