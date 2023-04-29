package com.hugidonic.kstuscheduler.di

import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.usecases.GetScheduleUseCase
import com.hugidonic.domain.usecases.LoadScheduleUseCase
import com.hugidonic.domain.usecases.SaveScheduleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetScheduleUseCase(
        scheduleRepository: ScheduleRepository
    ): GetScheduleUseCase {
        return GetScheduleUseCase(scheduleRepository = scheduleRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideLoadScheduleUseCase(
        scheduleRepository: ScheduleRepository
    ): LoadScheduleUseCase {
        return LoadScheduleUseCase(scheduleRepository = scheduleRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSaveScheduleUseCase(
        scheduleRepository: ScheduleRepository
    ): SaveScheduleUseCase {
        return SaveScheduleUseCase(scheduleRepository = scheduleRepository)
    }
}