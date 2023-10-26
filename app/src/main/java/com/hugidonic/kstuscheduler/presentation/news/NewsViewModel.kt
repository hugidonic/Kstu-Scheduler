package com.hugidonic.kstuscheduler.presentation.news

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.domain.usecases.news.GetNewsUseCase
import com.hugidonic.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<NewsState> = MutableStateFlow(NewsState())
    val stateFlow: StateFlow<NewsState> = _stateFlow.asStateFlow()

    private val _eventFlow = MutableSharedFlow<NewsUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        _stateFlow.value = _stateFlow.value.copy(
            currentNewsType = "Университетская жизнь"
        )
        getNewsByType(newsType = _stateFlow.value.currentNewsType)
    }

    private fun getNewsByType(isFetchFromRemote: Boolean = false, newsType: String = _stateFlow.value.currentNewsType) {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsUseCase(isFetchFromRemote = isFetchFromRemote, newsType = newsType)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _stateFlow.value = _stateFlow.value.copy(
                                newsList = result.data
                            )
                        }

                        is Resource.Error -> {
                            _eventFlow.emit(
                                NewsUiEvent.ShowSnackbar(
                                    result.message ?: "Что-то пошло не так..."
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

    fun onRefresh() {
        getNewsByType(isFetchFromRemote = true)
    }

    fun changeCurrentNewsType(newsType: String) {
        _stateFlow.value = _stateFlow.value.copy(
            currentNewsType = newsType
        )

        getNewsByType(newsType = newsType)
    }

}