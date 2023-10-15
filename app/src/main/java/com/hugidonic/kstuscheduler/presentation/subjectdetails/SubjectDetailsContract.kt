package com.hugidonic.kstuscheduler.presentation.subjectdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hugidonic.domain.models.SubjectModel


/**
 * UI State that represents SubjectDetailsScreen
 **/
data class SubjectDetailsState(
    val subjectDetails: SubjectModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

/**
 * SubjectDetails Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class SubjectDetailsActions(
    val onPrepodClick: (prepodId: Int) -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalSubjectDetailsActions = staticCompositionLocalOf<SubjectDetailsActions> {
    error("{NAME} Actions Were not provided, make sure ProvideSubjectDetailsActions is called")
}

@Composable
fun ProvideSubjectDetailsActions(actions: SubjectDetailsActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalSubjectDetailsActions provides actions) {
        content.invoke()
    }
}

