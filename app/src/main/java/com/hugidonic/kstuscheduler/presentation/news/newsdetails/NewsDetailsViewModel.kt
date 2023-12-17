package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.usecases.news.GetNewsByNewsIdUseCase
import com.hugidonic.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getNewsByNewsId: GetNewsByNewsIdUseCase,
) : ViewModel() {

    private val newsId: Int = checkNotNull(savedStateHandle["newsId"])

    private val _stateFlow: MutableStateFlow<NewsDetailsState> = MutableStateFlow(NewsDetailsState())
    val stateFlow: StateFlow<NewsDetailsState> = _stateFlow.asStateFlow()

    private val _errorFlow = MutableSharedFlow<NewsDetailsUIEvent>()
    val errorFlow: SharedFlow<NewsDetailsUIEvent> = _errorFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            getNewsByNewsId(newsId=newsId)
                .collect() {result ->
                        when(result) {
                            is Resource.Success -> {
                                _stateFlow.value = _stateFlow.value.copy(
                                    newsDetails = result.data
                                )
                            }
                            is Resource.Error -> {
                                _errorFlow.emit(
                                    NewsDetailsUIEvent.ShowSnackbar(
                                        message = result.message ?: "Что-то пошло не так..."
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
}