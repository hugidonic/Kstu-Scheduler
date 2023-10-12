package com.hugidonic.kstuscheduler.presentation.schedule

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.usecases.GetCurrentDateUseCase
import com.hugidonic.domain.usecases.GetTypeOfWeekUseCase
import com.hugidonic.domain.usecases.GetWeekScheduleDayUseCase
import com.hugidonic.domain.utils.Resource
import com.hugidonic.kstuscheduler.presentation.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import javax.inject.Inject

@OptIn(ExperimentalFoundationApi::class)
@HiltViewModel
class ScheduleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getWeekScheduleDayUseCase: GetWeekScheduleDayUseCase,
    getTypeOfWeekUseCase: GetTypeOfWeekUseCase,
    getCurrentDateUseCase: GetCurrentDateUseCase
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<ScheduleState> = MutableStateFlow(ScheduleState())
    val stateFlow: StateFlow<ScheduleState> = _stateFlow.asStateFlow()

    val currentDayOfWeek = getCurrentDateUseCase().dayOfWeek.ordinal
    private val currentTypeOfWeek = getTypeOfWeekUseCase()

    init {
        _stateFlow.value = _stateFlow.value.copy(
            currentTypeOfWeek = currentTypeOfWeek,
        )

        getWeekSchedule(currentTypeOfWeek)
    }

    private fun getWeekSchedule(typeOfWeek: String = currentTypeOfWeek) {
        viewModelScope.launch {
            getWeekScheduleDayUseCase(isFetchFromApi = true, typeOfWeek = typeOfWeek)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let {
                                _stateFlow.value = _stateFlow.value.copy(
                                    weekScheduleDays = it,
                                )
                            }
                        }

                        is Resource.Error -> {
                            result.data?.let {
                                _stateFlow.value = _stateFlow.value.copy(
                                    errorMessage = result.message ?: "",
                                )
                            }
                        }

                        is Resource.Loading -> {
                            _stateFlow.value = _stateFlow.value.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
        }
    }

    fun changeTypeOfWeek() {
        if (_stateFlow.value.currentTypeOfWeek == "Чет") {
            _stateFlow.value = _stateFlow.value.copy(
                currentTypeOfWeek = "Нечет"
            )
            getWeekSchedule(typeOfWeek = "Нечет")
        } else {
            _stateFlow.value = _stateFlow.value.copy(
                currentTypeOfWeek = "Чет"
            )
            getWeekSchedule(typeOfWeek = "Чет")
        }
    }

    fun editGroup(newGroup: String) {
        _stateFlow.value = _stateFlow.value.copy(
            group = newGroup
        )
        getWeekSchedule(typeOfWeek = currentTypeOfWeek)
    }
}