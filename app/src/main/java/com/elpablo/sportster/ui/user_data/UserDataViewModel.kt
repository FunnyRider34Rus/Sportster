package com.elpablo.sportster.ui.user_data

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UserDataViewModel @Inject constructor() : ViewModel() {
    private val _viewState = MutableStateFlow(UserDataViewState())
    val viewState: StateFlow<UserDataViewState> = _viewState

    fun onEvent(event: UserDataEvent) {
        when (event) {
            is UserDataEvent.OnSelectGender -> {
                _viewState.update {
                    it.copy(gender = event.value)
                }
                Log.d("sportster", event.value.type)
            }

            is UserDataEvent.OnSelectHeight -> {
                _viewState.update {
                    it.copy(height = event.value)
                }
                Log.d("sportster", event.value.toString())
            }

            is UserDataEvent.OnSelectWeight -> {
                _viewState.update {
                    it.copy(weight = event.value)
                }
                Log.d("sportster", event.value.toString())
            }
        }
    }
}