package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.usecases.schedule.GetWeekScheduleUseCase
import com.hugidonic.domain.usecases.utils.GetCurrentDateUseCase
import com.hugidonic.domain.usecases.utils.GetTypeOfWeekUseCase
import com.hugidonic.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getWeekScheduleUseCase: GetWeekScheduleUseCase,
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

        getWeekSchedule()
    }

    private fun getWeekSchedule(
        isFetchFromApi: Boolean = false,
        groupNumber: String = _stateFlow.value.group,
        typeOfWeek: String = _stateFlow.value.currentTypeOfWeek
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            getWeekScheduleUseCase(
                isFetchFromApi = isFetchFromApi,
                groupNumber = groupNumber,
                typeOfWeek = typeOfWeek
            )
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _stateFlow.value = _stateFlow.value.copy(
                                weekScheduleDays = result.data,
                                group = groupNumber,
                            )
                        }
                        is Resource.Error -> {
                            _eventFlow.emit(
                                ScheduleUIEvent.ShowSnackbar(
                                    result.message ?: "Something went wrong..."
                                )
                            )
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
        getWeekSchedule(isFetchFromApi = false, typeOfWeek = _stateFlow.value.currentTypeOfWeek)
    }

    fun refreshSchedule() {
        getWeekSchedule(isFetchFromApi = true)
    }

    fun editGroup(newGroup: String) {
        _stateFlow.value = _stateFlow.value.copy(
            group = newGroup
        )
        getWeekSchedule(isFetchFromApi = true, groupNumber = newGroup)
    }
}