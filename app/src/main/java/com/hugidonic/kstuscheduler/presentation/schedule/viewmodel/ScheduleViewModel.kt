package com.hugidonic.kstuscheduler.presentation.schedule.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.kstuscheduler.presentation.schedule.state.ScheduleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
): ViewModel() {

    var state by mutableStateOf(ScheduleState())

    init {
        viewModelScope.launch {
        }
    }
}