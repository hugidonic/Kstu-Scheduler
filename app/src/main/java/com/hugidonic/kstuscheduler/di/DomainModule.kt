package com.hugidonic.kstuscheduler.di

import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.usecases.GetCurrentDateUseCase
import com.hugidonic.domain.usecases.GetScheduleDayUseCase
import com.hugidonic.domain.usecases.GetTypeOfWeekUseCase
import com.hugidonic.domain.usecases.GetWeekScheduleDayUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {


    @Singleton
    @Provides
    fun provideGetWeekScheduleDayUseCase(scheduleRepository: ScheduleRepository): GetWeekScheduleDayUseCase {
        return GetWeekScheduleDayUseCase(scheduleRepository = scheduleRepository)
    }

    @Singleton
    @Provides
    fun provideGetScheduleDayUseCase(scheduleRepository: ScheduleRepository): GetScheduleDayUseCase {
        return GetScheduleDayUseCase(scheduleRepository = scheduleRepository)
    }

    @Singleton
    @Provides
    fun provideGetTypeOfWeekUseCase(scheduleRepository: ScheduleRepository): GetTypeOfWeekUseCase {
        return GetTypeOfWeekUseCase(scheduleRepository = scheduleRepository)
    }

    @Singleton
    @Provides
    fun provideGetCurrentDateUseCase(scheduleRepository: ScheduleRepository): GetCurrentDateUseCase {
        return GetCurrentDateUseCase(scheduleRepository = scheduleRepository)
    }
}