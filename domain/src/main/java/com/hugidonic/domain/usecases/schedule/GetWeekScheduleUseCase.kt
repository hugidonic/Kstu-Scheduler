package com.hugidonic.domain.usecases.schedule

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetWeekScheduleUseCase(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(
        isFetchFromApi: Boolean = false,
        groupNumber: String,
        typeOfWeek: String
    ): Flow<Resource<List<ScheduleDayModel>>> {
        return scheduleRepository.getWeekSchedule(
            groupNumber = groupNumber,
            isFetchFromApi = isFetchFromApi,
            typeOfWeek = typeOfWeek
        )
    }
}