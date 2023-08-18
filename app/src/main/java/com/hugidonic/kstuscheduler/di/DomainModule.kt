package com.hugidonic.kstuscheduler.di

import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.usecases.GetClassesUseCase
import com.hugidonic.domain.usecases.GetScheduleDayInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {


    @Singleton
    @Provides
    fun provideGetScheduleDayInfoUseCase(scheduleRepository: ScheduleRepository): GetScheduleDayInfoUseCase {
        return GetScheduleDayInfoUseCase(scheduleRepository = scheduleRepository)
    }

    @Singleton
    @Provides
    fun provideGetClassesUseCase(scheduleRepository: ScheduleRepository): GetClassesUseCase {
        return GetClassesUseCase(scheduleRepository = scheduleRepository)
    }

}