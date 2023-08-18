package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.usecases.GetClassesUseCase
import com.hugidonic.domain.usecases.GetScheduleDayInfoUseCase
import com.hugidonic.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlinx.coroutines.launch
import java.util.*

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getScheduleDayInfoUseCase: GetScheduleDayInfoUseCase,
    getClassesUseCase: GetClassesUseCase,
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<ScheduleState> = MutableStateFlow(ScheduleState())
    val stateFlow: StateFlow<ScheduleState> = _stateFlow.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    val weekDayList = listOf(
        "Пн",
        "Вт",
        "Ср",
        "Чт",
        "Пт",
        "Сб",
    )

    private val calendar = Calendar.getInstance()
    private val curDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 // 1-6 where 1 is monday and 6 is saturday
    private val dayOfWeek = weekDayList[curDayOfWeek]

    init {
        _stateFlow.value = _stateFlow.value.copy(
            todayDayOfWeek = dayOfWeek
        )

        viewModelScope.launch {
            getClassesUseCase(dayOfWeek = dayOfWeek).collectLatest {result ->
                when(result) {
                    is Resource.Success -> {
                        _stateFlow.value = _stateFlow.value.copy(
                            classes = result.data,
                        )
                    }
                    is Resource.Error -> {
                        _stateFlow.value = _stateFlow.value.copy(
                            classes = result.data,
                            errorMessage = result.message,
                        )
                    }
                    is Resource.Loading -> {
                        _stateFlow.value = _stateFlow.value.copy(
                            classes = result.data,
                            errorMessage = result.message,
                            isLoading = result.isLoading,
                        )
                    }
                }
            }
        }
    }
}