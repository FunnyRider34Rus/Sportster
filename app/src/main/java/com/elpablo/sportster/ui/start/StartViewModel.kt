package com.elpablo.sportster.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.sportster.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases): ViewModel() {
    fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry.invoke()
        }
    }
}