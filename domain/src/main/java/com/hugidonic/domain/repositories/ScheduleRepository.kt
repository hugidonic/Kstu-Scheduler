package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    suspend fun loadSchedule()
    suspend fun getSchedule(isFetchFromRemote: Boolean): Flow<Resource<ScheduleDayModel>>
}