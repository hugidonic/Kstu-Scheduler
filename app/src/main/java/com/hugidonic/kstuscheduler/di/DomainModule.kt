package com.hugidonic.kstuscheduler.di

import com.hugidonic.domain.repositories.NewsRepository
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.usecases.news.GetNewsByNewsIdUseCase
import com.hugidonic.domain.usecases.news.GetNewsUseCase
import com.hugidonic.domain.usecases.schedule.GetSubjectDetailsById
import com.hugidonic.domain.usecases.utils.GetTypeOfWeekUseCase
import com.hugidonic.domain.usecases.schedule.GetWeekScheduleUseCase
import com.hugidonic.domain.usecases.utils.GetCurrentDateUseCase
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
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(newsRepository = newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetNewsByNewsIdUseCase(newsRepository: NewsRepository): GetNewsByNewsIdUseCase {
        return GetNewsByNewsIdUseCase(newsRepository = newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetWeekScheduleUseCase(scheduleRepository: ScheduleRepository): GetWeekScheduleUseCase {
        return GetWeekScheduleUseCase(scheduleRepository = scheduleRepository)
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

    @Singleton
    @Provides
    fun provideGetSubjectDetailsById(scheduleRepository: ScheduleRepository): GetSubjectDetailsById {
        return GetSubjectDetailsById(scheduleRepository = scheduleRepository)
    }
}