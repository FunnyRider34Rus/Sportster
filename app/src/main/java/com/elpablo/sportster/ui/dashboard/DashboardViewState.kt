package com.elpablo.sportster.ui.dashboard

import com.elpablo.sportster.domain.model.User

data class DashboardViewState(
    val isUserLogged: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: String = "",
    val user: User? = User()
)
