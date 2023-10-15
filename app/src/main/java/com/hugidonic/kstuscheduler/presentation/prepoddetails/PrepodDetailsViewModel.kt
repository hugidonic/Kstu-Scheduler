package com.hugidonic.kstuscheduler.presentation.prepoddetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.dummy.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PrepodDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val prepodId = checkNotNull(savedStateHandle["prepodId"])
    private val _stateFlow: MutableStateFlow<PrepodDetailsState> = MutableStateFlow(PrepodDetailsState())
    val stateFlow: StateFlow<PrepodDetailsState> = _stateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(600L)
            _stateFlow.value = _stateFlow.value.copy(
                prepodDetails = DummyData.prepodDetails
            )
        }
    }
}