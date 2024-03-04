package com.elpablo.sportster.ui.dashboard

sealed class DashboardEvent {
    class Error(val errorMessage: String?) : DashboardEvent()
}