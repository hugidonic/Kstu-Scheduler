package com.hugidonic.kstuscheduler.di

import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.usecases.GetScheduleUseCase
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
}