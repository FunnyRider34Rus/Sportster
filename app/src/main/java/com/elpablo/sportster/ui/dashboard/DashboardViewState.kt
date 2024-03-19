package com.elpablo.sportster.ui.dashboard

import android.location.Location
import com.elpablo.sportster.domain.model.User
import java.util.Date

data class DashboardViewState(
    val isUserLogged: Boolean = false,
    val location: Location? = null,
    val startTrainig: Boolean = false,
    val timer: Long = Date().time,
    val steps: Int = 0,
    val range: Float = 0.0f,
    val ccal: Int = 0,
    val isTraining: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: String = "",
    val user: User? = User()
)
