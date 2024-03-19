package com.elpablo.sportster.ui.dashboard

import android.content.Context

sealed class DashboardEvent {
    class Error(val errorMessage: String?) : DashboardEvent()
    class Location(val context: Context) : DashboardEvent()
    class TrainingStart(val context: Context) : DashboardEvent()
}