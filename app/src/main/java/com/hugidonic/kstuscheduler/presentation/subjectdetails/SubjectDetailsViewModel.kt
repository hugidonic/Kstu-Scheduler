package com.hugidonic.kstuscheduler.presentation.subjectdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.usecases.GetSubjectDetailsById
import com.hugidonic.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubjectDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getSubjectDetailsById: GetSubjectDetailsById
) : ViewModel() {

    private val subjectId: Int = checkNotNull(savedStateHandle["subjectId"])
    private val _stateFlow: MutableStateFlow<SubjectDetailsState> = MutableStateFlow(SubjectDetailsState())
    val stateFlow: StateFlow<SubjectDetailsState> = _stateFlow.asStateFlow()

    init {
        getSubjectDetails(subjectId = subjectId)
    }

    private fun getSubjectDetails(subjectId: Int) {
        viewModelScope.launch {
            getSubjectDetailsById(subjectId = subjectId)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let {
                                _stateFlow.value = _stateFlow.value.copy(
                                    subjectDetails = it
                                )
                            }
                        }

                        is Resource.Error -> {
                            _stateFlow.value = _stateFlow.value.copy(
                                errorMessage = result.message
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
}