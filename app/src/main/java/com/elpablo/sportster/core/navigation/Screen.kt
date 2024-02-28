package com.elpablo.sportster.core.navigation

sealed class Screen(val route: String) {
    data object START : Screen(route = "start")
    data object DASHBOARD : Screen(route = "dashboard")
}