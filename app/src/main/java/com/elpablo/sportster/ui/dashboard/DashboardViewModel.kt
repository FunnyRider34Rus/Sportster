package com.elpablo.sportster.ui.dashboard

import androidx.lifecycle.ViewModel
import com.elpablo.sportster.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    val isUserAuthenticated get() = repository.isUserAuthenticatedInFirebase()
}