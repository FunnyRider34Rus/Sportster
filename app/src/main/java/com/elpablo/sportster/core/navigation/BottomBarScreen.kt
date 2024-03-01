package com.elpablo.sportster.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.elpablo.sportster.R

sealed class BottomBarScreen(
    val route: String,
    @StringRes val lable: Int,
    @DrawableRes val icon: Int
) {
    data object Dashboard : BottomBarScreen(
        route = Screen.DASHBOARD.route,
        lable = R.string.bottombar_lable_dashboard,
        icon = R.drawable.sneaker_outline
    )

    data object Analytics : BottomBarScreen(
        route = Screen.ANALYTICS.route,
        lable = R.string.bottombar_label_analytics,
        icon = R.drawable.statistics_outline
    )

    data object Profile : BottomBarScreen(
        route = Screen.PROFILE.route,
        lable = R.string.bottombar_label_profile,
        icon = R.drawable.user_outline
    )
}