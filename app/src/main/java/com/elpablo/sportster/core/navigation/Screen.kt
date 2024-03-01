package com.elpablo.sportster.core.navigation

sealed class Screen(val route: String) {
    data object START : Screen(route = "start")
    data object PERMISSIONS : Screen(route = "permissions")
    data object LOGIN : Screen(route = "login")
    data object DASHBOARD : Screen(route = "dashboard")
    data object ANALYTICS : Screen(route = "analytics")
    data object PROFILE : Screen(route = "profile")
}

sealed class Graph(val route: String) {
    data object ONBOARD : Graph(route = "onboard")
    data object MAIN : Graph(route =  "main")
}