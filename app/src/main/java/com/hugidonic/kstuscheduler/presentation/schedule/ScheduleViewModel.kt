package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.usecases.GetCurrentDateUseCase
import com.hugidonic.domain.usecases.GetTypeOfWeekUseCase
import com.hugidonic.domain.usecases.GetWeekScheduleDayUseCase
import com.hugidonic.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getWeekScheduleDayUseCase: GetWeekScheduleDayUseCase,
    getTypeOfWeekUseCase: GetTypeOfWeekUseCase,
    getCurrentDateUseCase: GetCurrentDateUseCase
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<ScheduleState> = MutableStateFlow(ScheduleState())
    val stateFlow: StateFlow<ScheduleState> = _stateFlow.asStateFlow()

    private val _eventFlow = MutableSharedFlow<ScheduleUIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

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
                .catch {
                    _eventFlow.emit(
                        ScheduleUIEvent.ShowSnackbar(
                            it.message ?: "Something went wrong..."
                        )
                    )
                }
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
                                _eventFlow.emit(
                                    ScheduleUIEvent.ShowSnackbar(
                                        result.message ?: "Something went wrong..."
                                    )

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
        } else {
            _stateFlow.value = _stateFlow.value.copy(
                currentTypeOfWeek = "Чет"
            )
        }
        getWeekSchedule()
    }

    fun editGroup(newGroup: String) {
        _stateFlow.value = _stateFlow.value.copy(
            group = newGroup
        )
        getWeekSchedule()
    }
}