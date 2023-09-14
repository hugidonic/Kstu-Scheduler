package com.hugidonic.domain.usecases

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetWeekScheduleDayUseCase(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(
        isFetchFromApi: Boolean = false,
        typeOfWeek: String
    ): Flow<Resource<List<ScheduleDayModel>>> {
        return scheduleRepository.getWeekSchedule(isFetchFromApi = isFetchFromApi, typeOfWeek = typeOfWeek)
    }
}