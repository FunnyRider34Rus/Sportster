package com.elpablo.sportster.ui.dashboard

import com.elpablo.sportster.ui.login.LoginEvent

sealed class DashboardEvent {
    class Error(val errorMessage: String?) : DashboardEvent()
}